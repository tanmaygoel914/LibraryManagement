package service;

import entity.User;
import repository.UserRepository;

public class UserService {
    private final UserRepository userRepo;

    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public void addUser(User user) {
        userRepo.addUser(user);
    }

    public User getUser(int id) {
        return userRepo.getUser(id);
    }
}
