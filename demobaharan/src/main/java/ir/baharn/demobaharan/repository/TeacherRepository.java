package ir.baharn.demobaharan.repository;

import ir.baharn.demobaharan.model.Person;
import ir.baharn.demobaharan.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    @Query("FROM Teacher ")
    List<Teacher> getAllCustom();

    Teacher findByPersonId(Long personId);

    @Query("SELECT t FROM Teacher t WHERE t.id = :id")
    Teacher findTeacherById(@Param("id") Long id);

    boolean existsByPerson(Person person);

    @Query("SELECT t FROM Teacher t WHERE t.person = :person")
    Teacher findByPerson(@Param("person") Person person);
}
