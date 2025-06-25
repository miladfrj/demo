package ir.baharn.demobaharan.service.impl;

import ir.baharn.demobaharan.model.Department;
import ir.baharn.demobaharan.repository.DepartmentRepository;
import ir.baharn.demobaharan.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImplDepartmentService implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public List<Department> getAll() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getById(Long id) {
        return departmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("دپارتمان یافت نشد!"));
    }

    @Override
    public Department save(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public void delete(Long id) {
        if (!departmentRepository.existsById(id)){
            throw new RuntimeException("دپارتمان یافت نشد!");
        }
        departmentRepository.deleteById(id);
    }
}
