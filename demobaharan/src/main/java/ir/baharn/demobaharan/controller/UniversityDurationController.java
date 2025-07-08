package ir.baharn.demobaharan.controller;

import ir.baharn.demobaharan.model.Teacher;
import ir.baharn.demobaharan.model.UniversityDuration;
import ir.baharn.demobaharan.service.CourseService;
import ir.baharn.demobaharan.service.TeacherService;
import ir.baharn.demobaharan.service.UniversityDurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/university-duration")
public class UniversityDurationController {

    @Autowired
    UniversityDurationService universityDurationService;

    @Autowired
    CourseService courseService;

    @Autowired
    TeacherService teacherService;

    @PreAuthorize("hasRole('STUDENT')")
    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("duration", new UniversityDuration());
        model.addAttribute("courses" , courseService.getAll());
        model.addAttribute("teachers" , teacherService.getAll());
        return "duration-form";
    }

    @PreAuthorize("hasRole('STUDENT')")
    @PostMapping("/save")
    public String save(@ModelAttribute UniversityDuration universityDuration) {
        universityDurationService.save(universityDuration);
        return "redirect:/university-duration/list";
    }

    @PreAuthorize("hasRole('STUDENT')")
    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("durations", universityDurationService.getAll());
        return "duration-list";
    }
}
