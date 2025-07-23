package ir.baharn.demobaharan.controller;

import ir.baharn.demobaharan.model.Department;
import ir.baharn.demobaharan.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public String list(Model model, Principal principal) {
        model.addAttribute("username", principal.getName());
        model.addAttribute("departments", departmentService.getAll());
        return "departments-list";
    }

    @GetMapping("/new")
    @PreAuthorize("hasRole('ADMIN')")
    public String createForm(Model model, Principal principal) {
        model.addAttribute("username", principal.getName());
        model.addAttribute("department", new Department());
        return "department-form";
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public String save(@ModelAttribute Department department) {
        departmentService.save(department);
        return "redirect:/departments";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        Department department = departmentService.getById(id);
        model.addAttribute("department", department);
        model.addAttribute("isEdit", true);
        return "department-form";
    }

    @GetMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String delete(@PathVariable Long id) {
        departmentService.delete(id);
        return "redirect:/departments";
    }
}
