package ir.baharn.demobaharan.service;

import ir.baharn.demobaharan.model.Course;

import java.util.List;

public interface CourseService {

    List<Course> getAll();

    Course getById(Long id);

    Course save(Course course);

    void delete(Long id);
}
