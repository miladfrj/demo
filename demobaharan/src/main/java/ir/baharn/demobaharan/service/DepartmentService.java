package ir.baharn.demobaharan.service;

import ir.baharn.demobaharan.model.Department;

import java.util.List;

public interface DepartmentService {
    List<Department> getAll();

    Department getById(Long id);

    Department save(Department department);

    void delete(Long id);
}
