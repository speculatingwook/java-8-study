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

    public List<User> filterUsers(Predicate<User> predicate) {
        // todo
        return null;
    }

    public void processUsers(Consumer<User> consumer) {
        // todo
    }

    public <R> List<R> mapUsers(Function<User, R> mapper) {
        // todo
        return null;
    }

    public Optional<User> findUser(Predicate<User> predicate) {
        // todo
        return null;
    }

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