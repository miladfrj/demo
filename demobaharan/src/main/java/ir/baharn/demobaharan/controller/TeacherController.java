package ir.baharn.demobaharan.controller;

import ir.baharn.demobaharan.model.Person;
import ir.baharn.demobaharan.model.Role;
import ir.baharn.demobaharan.model.Teacher;
import ir.baharn.demobaharan.service.PersonService;
import ir.baharn.demobaharan.service.StudentService;
import ir.baharn.demobaharan.service.TeacherService;
import ir.baharn.demobaharan.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping("/teachers")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private UserService userService;

    @Autowired
    private PersonService personService;

    @GetMapping
    @PreAuthorize("hasAnyRole('TEACHER', 'ADMIN')")
    public String list(Model model, Principal principal) {
        model.addAttribute("username", principal.getName());
        model.addAttribute("teachers", teacherService.getAll());
        return "teachers-list";
    }

    @GetMapping("/new")
    @PreAuthorize("hasAnyRole('TEACHER', 'ADMIN')")
    public String createForm(Model model, Principal principal) {
        model.addAttribute("username", principal.getName());
        model.addAttribute("teacher", new Teacher());
        model.addAttribute("persons", personService.getAll());
        return "teacher-form";
    }


    @PostMapping
    @PreAuthorize("hasAnyRole('TEACHER', 'ADMIN')")
    public String save(@RequestParam("personId") Long personId,
                       @RequestParam("teacherCode") String teacherCode) {
        teacherService.saveWithPerson(personId, teacherCode);
        return "redirect:/teachers";
    }

    @GetMapping("/delete/{id}")
    @PreAuthorize("hasAnyRole('TEACHER', 'ADMIN')")
    public String delete(@PathVariable Long id) {
        teacherService.delete(id);
        return "redirect:/teachers";
    }
}
