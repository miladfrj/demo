package ir.baharn.demobaharan.service.impl;

import ir.baharn.demobaharan.model.Student;
import ir.baharn.demobaharan.repository.StudentRepository;
import ir.baharn.demobaharan.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImplStudentService implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAll() {
        return studentRepository.getAllCustom();
    }

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void delete(Long id) {
        studentRepository.deleteById(id);
    }
}
