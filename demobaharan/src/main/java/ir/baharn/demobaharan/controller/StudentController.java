package ir.baharn.demobaharan.controller;

import ir.baharn.demobaharan.model.Person;
import ir.baharn.demobaharan.model.Role;
import ir.baharn.demobaharan.model.Student;
import ir.baharn.demobaharan.service.PersonService;
import ir.baharn.demobaharan.service.StudentService;
import ir.baharn.demobaharan.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private PersonService personService;

    @GetMapping
    @PreAuthorize("hasAnyRole('STUDENT', 'ADMIN')")
    public String list(Model model, Principal principal) {
        model.addAttribute("username", principal.getName());
        model.addAttribute("students", studentService.getAll());
        return "students-list";
    }

    @GetMapping("/new")
    @PreAuthorize("hasAnyRole('STUDENT', 'ADMIN')")
    public String createForm(Model model, Principal principal) {
        model.addAttribute("username", principal.getName());
        model.addAttribute("student", new Student());
        model.addAttribute("persons", personService.getAll());
        return "student-form";
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('STUDENT', 'ADMIN')")
    public String save(@RequestParam("personId") Long personId,
                       @RequestParam("studentCode") String studentCode,
                       @RequestParam("proMajor") String proMajor) {
        Person person = personService.getEntityById(personId);
        Student student = new Student();
        student.setPerson(person);
        student.setStudentCode(studentCode);
        student.setProMajor(proMajor);
        studentService.save(student);

        return "redirect:/students";
    }

    @GetMapping("/delete/{id}")
    @PreAuthorize("hasAnyRole('STUDENT', 'ADMIN')")
    public String delete(@PathVariable Long id) {
        studentService.delete(id);
        return "redirect:/students";
    }
}

