package repository;

import model.User;
import java.util.*;

public class UserRepository {
    private final Map<Integer, User> users = new HashMap<>();

    public void addUser(User user) {
        users.put(user.getId(), user);
    }

    public User getUser(int id) {
        return users.get(id);
    }

    public Collection<User> getAllUsers() {
        return users.values();
    }
}
