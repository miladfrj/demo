package ir.baharn.demobaharan.repository;

import ir.baharn.demobaharan.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    @Query("SELECT d FROM Department d")
    List<Department> findAllDepartments();

    @Query("SELECT d FROM Department d WHERE d.id = :id")
    Department findDepartmentById(@Param("id") Long id);
}
