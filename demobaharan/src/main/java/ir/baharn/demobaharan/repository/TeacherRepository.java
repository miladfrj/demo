package ir.baharn.demobaharan.repository;

import ir.baharn.demobaharan.model.Person;
import ir.baharn.demobaharan.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    @Query("FROM Teacher ")
    List<Teacher> getAllCustom();

    boolean existsByPerson(Person person);
}
