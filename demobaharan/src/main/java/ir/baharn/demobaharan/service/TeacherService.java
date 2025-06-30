package ir.baharn.demobaharan.service;

import ir.baharn.demobaharan.model.Teacher;

import java.util.List;

public interface TeacherService {
    List<Teacher> getAll();
    Teacher save(Teacher teacher);
    void delete(Long id);
}
