package ir.baharn.demobaharan.service;

import ir.baharn.demobaharan.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAll();
    Student save(Student student);
    void delete(Long id);
}
