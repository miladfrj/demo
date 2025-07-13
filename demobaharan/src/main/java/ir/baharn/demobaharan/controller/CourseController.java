package ir.baharn.demobaharan.controller;

import ir.baharn.demobaharan.model.Course;
import ir.baharn.demobaharan.model.Duration;
import ir.baharn.demobaharan.model.Role;
import ir.baharn.demobaharan.service.CourseService;
import ir.baharn.demobaharan.service.TeacherService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private TeacherService teacherService;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("courses", courseService.getAll());
        return "courses-list";
    }

    @GetMapping("/new")
    public String createForm(Model model , HttpSession session) {
        Role role = (Role) session.getAttribute("role");
        if (role !=Role.TEACHER && role !=Role.ADMIN) {
            return "redirect:/access-denied";
        }
        model.addAttribute("course", new Course());
        model.addAttribute("teachers", teacherService.getAll());
        model.addAttribute("duration", Duration.values());

        return "course-form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Course course , HttpSession session) {
        Role role = (Role) session.getAttribute("role");
        if (role !=Role.TEACHER && role !=Role.ADMIN) {
            return "redirect:/access-denied";
        }
        courseService.save(course);
        return "redirect:/courses";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id , HttpSession session) {
        Role role = (Role) session.getAttribute("role");
        if (role !=Role.TEACHER && role !=Role.ADMIN) {
            return "redirect:/access-denied";
        }
        courseService.delete(id);
        return "redirect:/courses";
    }

}
