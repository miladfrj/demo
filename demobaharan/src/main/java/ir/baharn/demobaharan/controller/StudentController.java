package ir.baharn.demobaharan.controller;

import ir.baharn.demobaharan.model.Person;
import ir.baharn.demobaharan.model.Student;
import ir.baharn.demobaharan.service.PersonService;
import ir.baharn.demobaharan.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private PersonService personService;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("students", studentService.getAll());
        return "students-list";
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("persons", personService.getAll());
        return "student-form";
    }

    @PostMapping
    public String save(@RequestParam("personId") Long personId, @RequestParam("studentCode") String studentCode) {
        Person person = personService.getEntityById(personId);
        if (person != null) {
            Student student = new Student();
            student.setPerson(person);
            student.setStudentCode(studentCode);
            studentService.save(student);
        }
        return "redirect:/students";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        studentService.delete(id);
        return "redirect:/students";
    }
}
