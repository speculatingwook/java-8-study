package org.speculatingwook.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.speculatingwook.user.User;
import org.speculatingwook.user.UserService;

import java.util.*;

/**
 * UserService의 모든 테스트를 통과해보자.
 * - 테스트 코드가 성공적으로 동작 가능하도록 user 디렉토리의 코드를 작성해보자.
 */
public class UserServiceTest {
    private UserService userService;

    @BeforeEach
    public void setUp() {
        userService = new UserService();
        userService.addUser(new User("Alice", 25, "HR"));
        userService.addUser(new User("Bob", 30, "IT"));
        userService.addUser(new User("Charlie", 35, "Finance"));
        userService.addUser(new User("David", 40, "IT"));
        userService.addUser(new User("Eve", 28, "HR"));
    }

    @Test
    public void testFilterUsersByAge() {
        List<User> users = userService.filterUsers(user -> user.getAge() > 30);
        assertEquals(2, users.size());
        assertTrue(users.stream().allMatch(user -> user.getAge() > 30));
    }

    @Test
    public void testFilterUsersByName() {
        List<User> users = userService.filterUsers(user -> user.getName().startsWith("A"));
        assertEquals(1, users.size());
        assertEquals("Alice", users.get(0).getName());
    }

    @Test
    public void testProcessUsers() {
        final int[] count = {0};
        userService.processUsers(user -> {
            if (user.getAge() < 35) {
                count[0]++;
            }
        });
        assertEquals(3, count[0]);
    }

    @Test
    public void testMapUsers() {
        List<String> names = userService.mapUsers(User::getName);
        assertEquals(Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve"), names);
    }

    @Test
    public void testFindUser() {
        Optional<User> user = userService.findUser(u -> u.getDepartment().equals("Finance"));
        assertTrue(user.isPresent());
        assertEquals("Charlie", user.get().getName());
    }

    @Test
    public void testSortUsers() {
        userService.sortUsers(Comparator.comparing(User::getAge).reversed());
        List<User> sortedUsers = userService.getUsers();
        assertEquals(40, sortedUsers.get(0).getAge());
        assertEquals(25, sortedUsers.get(sortedUsers.size() - 1).getAge());
    }

    @Test
    public void testGroupUsersByDepartment() {
        Map<String, List<User>> groupedUsers = userService.groupUsersByDepartment();
        assertEquals(3, groupedUsers.size());
        assertEquals(2, groupedUsers.get("HR").size());
        assertEquals(2, groupedUsers.get("IT").size());
        assertEquals(1, groupedUsers.get("Finance").size());
    }

    @Test
    public void testGetAverageAge() {
        double averageAge = userService.getAverageAge();
        assertEquals(31.6, averageAge, 0.1);
    }
}
