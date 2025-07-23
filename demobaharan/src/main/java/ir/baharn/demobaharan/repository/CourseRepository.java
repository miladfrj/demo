package ir.baharn.demobaharan.repository;

import ir.baharn.demobaharan.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    @Query("SELECT c FROM Course c")
    List<Course> findAllCourses();

    @Query("SELECT c FROM Course c WHERE c.id = :id")
    Course findCourseById(@Param("id") Long id);
}
