package ir.baharn.demobaharan.service.impl;

import ir.baharn.demobaharan.model.User;
import ir.baharn.demobaharan.repository.UserRepository;
import ir.baharn.demobaharan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImplUserService implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User login(String username, String password){
        return userRepository.findByUsernameAndPassword(username , password);
    }

    @Override
    public User save(User user) {

        if (userRepository.existsByUsername(user.getUsername())) {
            throw new RuntimeException("نام کاربری تکراری است");
        }
        return userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
