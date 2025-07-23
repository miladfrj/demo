package ir.baharn.demobaharan.controller;

import ir.baharn.demobaharan.model.Course;
import ir.baharn.demobaharan.model.Duration;
import ir.baharn.demobaharan.model.Role;
import ir.baharn.demobaharan.service.CourseService;
import ir.baharn.demobaharan.service.DepartmentService;
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
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private DepartmentService departmentService;


    @Autowired
    private UserService userService;

    @GetMapping
    @PreAuthorize("hasAnyRole('TEACHER', 'ADMIN')")
    public String list(Model model, Principal principal) {
        model.addAttribute("username", principal.getName());
        model.addAttribute("courses", courseService.getAll());
        return "courses-list";
    }

    @GetMapping("/new")
    @PreAuthorize("hasAnyRole('TEACHER', 'ADMIN')")
    public String createForm(Model model, Principal principal) {
        model.addAttribute("username", principal.getName());
        model.addAttribute("course", new Course());
        model.addAttribute("teachers", teacherService.getAll());
        model.addAttribute("departments", departmentService.getAll());
        return "course-form";
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('TEACHER', 'ADMIN')")
    public String save(@ModelAttribute Course course) {
        courseService.save(course);
        return "redirect:/courses";
    }

    @GetMapping("/delete/{id}")
    @PreAuthorize("hasAnyRole('TEACHER', 'ADMIN')")
    public String delete(@PathVariable Long id) {
        courseService.delete(id);
        return "redirect:/courses";
    }

}
