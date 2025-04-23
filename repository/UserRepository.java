package repository;

import entity.User;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class UserRepository {
    private Map<String, User> users = new HashMap<>();

    public UserRepository() {
        addUser(new User("1", "Ayush"));
        addUser(new User("2", "Keshav"));
        addUser(new User("3", "Rachit"));
    }

    public boolean addUser(User user) {
        if (users.containsKey(user.getId())) return false;
        users.put(user.getId(), user);
        return true;
    }

    public User getUserById(String id) {
        return users.get(id);
    }


    public boolean removeUser(User user)  {
        if (!users.containsKey(user.getId())) return false;
        users.remove(user.getId(), user);
        return true;
    }
    public boolean userExists(String id) {
        return users.containsKey(id);
    }
    public Collection<User> getAllBooks() {
        return users.values();
    }
}
