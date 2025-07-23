package ir.baharn.demobaharan.repository;

import ir.baharn.demobaharan.model.UniversityDuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UniversityDurationRepository extends JpaRepository<UniversityDuration, Long> {
    @Query("SELECT ud FROM UniversityDuration ud")
    List<UniversityDuration> findAllUniversityDuration();

    @Query("SELECT ud FROM UniversityDuration ud WHERE ud.id = :id")
    UniversityDuration findUniversityDurationById(@Param("id") Long id);

    @Query("SELECT u FROM UniversityDuration u WHERE u.course.id = :courseId")
    List<UniversityDuration> findByCourseId(@Param("courseId") Long courseId);
}
