package ir.baharn.demobaharan.service;

import ir.baharn.demobaharan.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAll();

    Optional<User> login(String username, String password);

    User save(User user);

    void delete(Long id);
}
