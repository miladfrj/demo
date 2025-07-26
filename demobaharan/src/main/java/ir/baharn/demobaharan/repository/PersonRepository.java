package ir.baharn.demobaharan.repository;

import ir.baharn.demobaharan.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query("SELECT p FROM Person p")
    List<Person> findAllPersons();

}
