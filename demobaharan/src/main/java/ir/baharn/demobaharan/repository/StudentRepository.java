package ir.baharn.demobaharan.repository;

import ir.baharn.demobaharan.dto.PersonDTO;
import ir.baharn.demobaharan.model.Person;
import ir.baharn.demobaharan.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query("FROM Student ")
    List<Student> getAllCustom();

    boolean existsByPerson(Person person);
}
