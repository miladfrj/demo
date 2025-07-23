package ir.baharn.demobaharan.service.impl;

import ir.baharn.demobaharan.model.Student;
import ir.baharn.demobaharan.model.Teacher;
import ir.baharn.demobaharan.model.UnitSelection;
import ir.baharn.demobaharan.model.User;
import ir.baharn.demobaharan.repository.StudentRepository;
import ir.baharn.demobaharan.repository.TeacherRepository;
import ir.baharn.demobaharan.repository.UnitSelectionRepository;
import ir.baharn.demobaharan.repository.UserRepository;
import ir.baharn.demobaharan.service.UnitSelectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImplUnitSelectionService implements UnitSelectionService {

    @Autowired
    private UnitSelectionRepository unitSelectionRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TeacherRepository teacherRepository;


    @Override
    public UnitSelection save(UnitSelection selection) {
        return unitSelectionRepository.save(selection);
    }
    @Override
    public List<UnitSelection> findAll() {
        return unitSelectionRepository.findAllUnitSelection();
    }

    @Override
    public List<UnitSelection> getSelectionsByStudent(Long studentId) {
        return unitSelectionRepository.findByStudentId(studentId);
    }

    @Override
    public void saveByUsername(String username, UnitSelection unitSelection) {
        Optional<User> user = Optional.ofNullable(userRepository.findByUsername(username));
        throw new RuntimeException("کاربر پیدا نشد یا اطلاعات ناقص است");

    }

    @Override
    public List<UnitSelection> getSelectionsByTeacherUsername(String username) {
        Optional<User> user = Optional.ofNullable(userRepository.findByUsername(username));
        if (user.isEmpty() || user.get().getPerson() == null) {
            throw new RuntimeException("کاربر پیدا نشد یا اطلاعات ناقص است");
        }

        Teacher teacher = teacherRepository.findByPersonId(user.get().getPerson().getId());
        if (teacher == null) {
            throw new RuntimeException("استادی برای این کاربر یافت نشد");
        }

        return null;
    }

}
