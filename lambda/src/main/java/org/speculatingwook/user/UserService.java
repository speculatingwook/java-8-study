package org.speculatingwook.user;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class UserService {
    private List<User> users = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
    }

    /**
     * 파라미터의 변수는 변경하지 않는다.
     * @param predicate
     * @return
     */
    public List<User> filterUsers(Predicate<User> predicate) {
        // todo
        return null;
    }

    /**
     * 파라미터의 변수는 변경하지 않는다.
     * @param consumer
     */
    public void processUsers(Consumer<User> consumer) {
        // todo
    }

    /**
     * 파라미터의 변수는 변경하지 않는다.
     * @param mapper
     * @return
     * @param <R>
     */
    public <R> List<R> mapUsers(Function<User, R> mapper) {
        // todo
        return null;
    }

    /**
     * 파라미터의 변수는 변경하지 않는다.
     * @param predicate
     * @return
     */
    public Optional<User> findUser(Predicate<User> predicate) {
        // todo
        return null;
    }

    /**
     * 파라미터의 변수는 변경하지 않는다.
     * @param comparator
     */
    public void sortUsers(Comparator<User> comparator) {
        // todo
    }

    public Map<String, List<User>> groupUsersByDepartment() {
        // todo
        return null;
    }

    public double getAverageAge() {
        // todo
        return 0;
    }

    public List<User> getUsers() {
        return new ArrayList<>(users);
    }
}