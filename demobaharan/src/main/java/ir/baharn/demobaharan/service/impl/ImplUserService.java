package ir.baharn.demobaharan.service.impl;

import ir.baharn.demobaharan.model.Role;
import ir.baharn.demobaharan.model.User;
import ir.baharn.demobaharan.repository.UserRepository;
import ir.baharn.demobaharan.service.PersonService;
import ir.baharn.demobaharan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ImplUserService implements UserService, UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private PersonService personService;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public void assignRoleToUser(User user, String role) {
        if (role != null && !role.isEmpty()) {
            try {

                user.setRole(Role.valueOf(role));
            } catch (IllegalArgumentException e) {
                String personRole = personService.getPersonRoleByEntity(user.getPerson());
                switch (personRole) {
                    case "STUDENT":
                        user.setRole(Role.STUDENT);
                        break;
                    case "TEACHER":
                        user.setRole(Role.TEACHER);
                        break;
                    default:
                        user.setRole(Role.ADMIN);
                }
            }
        } else {
            String personRole = personService.getPersonRoleByEntity(user.getPerson());
            switch (personRole) {
                case "STUDENT":
                    user.setRole(Role.STUDENT);
                    break;
                case "TEACHER":
                    user.setRole(Role.TEACHER);
                    break;
                default:
                    user.setRole(Role.ADMIN);
            }
        }
    }


    @Override
    public User save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (username == null || username.isEmpty()) {
            throw new UsernameNotFoundException("Invalid username or password");
        }
        User user = userRepository.findByUsername(username);
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + user.getRole().name())));
    }
}
