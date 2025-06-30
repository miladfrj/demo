package ir.baharn.demobaharan.service;

import ir.baharn.demobaharan.model.User;

import java.util.List;

public interface UserService {
    List<User> getAll();

    User login(String username, String password);

    User save(User user);

    void delete(Long id);
}
