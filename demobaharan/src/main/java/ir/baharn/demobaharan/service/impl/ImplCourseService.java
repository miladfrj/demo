package ir.baharn.demobaharan.service.impl;

import ir.baharn.demobaharan.model.Course;
import ir.baharn.demobaharan.repository.CourseRepository;
import ir.baharn.demobaharan.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImplCourseService implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Course> getAll() {
        return courseRepository.findAll();
    }

    @Override
    public Course getById(Long id) {
        return courseRepository.findById(id).
                orElseThrow(() -> new RuntimeException("درس مورد نظر پیدا نشد!"));
    }

    @Override
    public Course save(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public void delete(Long id) {
        if (courseRepository.existsById(id)) {
            throw new RuntimeException("درس یسافت نشد!");
        }
        courseRepository.deleteById(id);
    }
}
