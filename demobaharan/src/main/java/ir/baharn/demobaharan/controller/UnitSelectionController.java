package ir.baharn.demobaharan.controller;

import ir.baharn.demobaharan.model.Role;
import ir.baharn.demobaharan.model.UnitSelection;
import ir.baharn.demobaharan.service.StudentService;
import ir.baharn.demobaharan.service.UnitSelectionService;
import ir.baharn.demobaharan.service.UniversityDurationService;
import ir.baharn.demobaharan.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/unit-selection")
public class UnitSelectionController {

    @Autowired
    private UnitSelectionService unitSelectionService;
    @Autowired
    private StudentService studentService;

    @Autowired
    private UserService userService;

    @Autowired
    private UniversityDurationService universityDurationService;

    @GetMapping("/form")
    @PreAuthorize("hasRole('STUDENT')")
    public String showForm(Model model, Principal principal) {
        model.addAttribute("unitSelection", new UnitSelection());
        model.addAttribute("students", studentService.getAll());
        model.addAttribute("durations", universityDurationService.getAll());
        return "unit-selection-form";
    }

    @PostMapping("/save")
    @PreAuthorize("hasRole('STUDENT')")
    public String save(@ModelAttribute UnitSelection unitSelection, Principal principal, Model model) {
        try {
            unitSelectionService.saveByUsername(principal.getName(), unitSelection);
            return "redirect:/unit-selection/list";
        } catch (RuntimeException e) {
            model.addAttribute("error", e.getMessage());
            model.addAttribute("unitSelection", unitSelection);
            model.addAttribute("students", studentService.getAll());
            model.addAttribute("durations", universityDurationService.getAll());
            return "unit-selection-form";
        }
    }

    @GetMapping("/teacher-list")
    @PreAuthorize("hasAnyRole('TEACHER','ADMIN')")
    public String teacherList(Principal principal, Model model) {
        try {
            model.addAttribute("selections", unitSelectionService.getSelectionsByTeacherUsername(principal.getName()));
            return "unit-selection-list";
        } catch (RuntimeException e) {
            model.addAttribute("error", e.getMessage());
            return "access-denied";
        }
    }

    @GetMapping("/list")
    public String list(Principal principal, Model model) {
        model.addAttribute("selections", unitSelectionService.findAll());
        return "unit-selection-list";
    }
}

