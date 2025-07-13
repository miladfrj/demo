package ir.baharn.demobaharan.controller;

import ir.baharn.demobaharan.model.Role;
import ir.baharn.demobaharan.model.UnitSelection;
import ir.baharn.demobaharan.service.StudentService;
import ir.baharn.demobaharan.service.UnitSelectionService;
import ir.baharn.demobaharan.service.UniversityDurationService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/unit-selection")
public class UnitSelectionController {

    @Autowired
    private  UnitSelectionService unitSelectionService;
    @Autowired
    private  StudentService studentService;
    @Autowired
    private UniversityDurationService universityDurationService;

    @GetMapping("/form")
    public String showForm(Model model , HttpSession session) {
        Role role = (Role) session.getAttribute("role");
        if (role !=Role.STUDENT && role !=Role.ADMIN) {
            return "redirect:/access-denied";
        }
        model.addAttribute("unitSelection", new UnitSelection());
        model.addAttribute("students", studentService.getAll());
        model.addAttribute("durations", universityDurationService.getAll());
        return "unit-selection-form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute UnitSelection unitSelection , HttpSession session) {
        Role role = (Role) session.getAttribute("role");
        if (role !=Role.STUDENT && role !=Role.ADMIN) {
            return "redirect:/access-denied";
        }
        unitSelectionService.save(unitSelection);
        return "redirect:/unit-selection/list";
    }

    @GetMapping("/list")
    public String list(Model model , HttpSession session) {
        Role role = (Role) session.getAttribute("role");
        if (role !=Role.STUDENT && role !=Role.ADMIN) {
            return "redirect:/access-denied";
        }
        model.addAttribute("selections", unitSelectionService.findAll());
        return "unit-selection-list";
    }
}
