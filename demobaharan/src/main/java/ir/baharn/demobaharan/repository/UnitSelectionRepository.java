package ir.baharn.demobaharan.repository;

import ir.baharn.demobaharan.model.UnitSelection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UnitSelectionRepository extends JpaRepository<UnitSelection, Long> {

    @Query("SELECT us FROM UnitSelection us")
    List<UnitSelection> findAllUnitSelection();

    @Query("SELECT u FROM UnitSelection u WHERE u.student.id = :studentId")
    List<UnitSelection> findByStudentId(Long studentId);

    //List<UnitSelection> findByTeacherId(Long teacherId);


   /* @Query("SELECT us FROM UnitSelection us WHERE us.id = :id")
    UnitSelection findUnitSelectionById(@Param("id") Long id);*/


    /*@Query("SELECT u FROM UnitSelection u WHERE u.universityDuration.teacher.id = :teacherId")
    List<UnitSelection> findByTeacherIdInUniversityDuration(@Param("teacherId") Long teacherId);
*/

}
