package ir.baharn.demobaharan.repository;

import ir.baharn.demobaharan.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
   // List<User> existsByUsername(String username);
    Optional<User> findByUsernameAndPassword(String username, String password);
}

