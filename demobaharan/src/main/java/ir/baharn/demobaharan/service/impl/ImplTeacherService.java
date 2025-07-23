package ir.baharn.demobaharan.service.impl;

import ir.baharn.demobaharan.model.Person;
import ir.baharn.demobaharan.model.Teacher;
import ir.baharn.demobaharan.repository.PersonRepository;
import ir.baharn.demobaharan.repository.TeacherRepository;
import ir.baharn.demobaharan.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImplTeacherService implements TeacherService {

    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    PersonRepository personRepository;

    @Override
    public List<Teacher> getAll() {
        return teacherRepository.getAllCustom();
    }

    @Override
    public Teacher save(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public void delete(Long id) {
        teacherRepository.deleteById(id);
    }

    @Override
    public void saveWithPerson(Long personId, String teacherCode) {
        Person person = personRepository.findById(personId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid personId"));

        Teacher teacher = new Teacher();
        teacher.setTeacherCode(teacherCode);
        teacher.setPerson(person);

        teacherRepository.save(teacher);
    }
}
