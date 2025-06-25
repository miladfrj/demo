package ir.baharn.demobaharan.controller;

import ir.baharn.demobaharan.model.Department;
import ir.baharn.demobaharan.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("department", new Department());
        return "department-form";
    }

    @PostMapping
    public String save(@ModelAttribute Department department) {
        departmentService.save(department);
        return "redirect:/persons/new";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        Department department = departmentService.getById(id);
        model.addAttribute("department", department);
        model.addAttribute("isEdit", true);
        return "department-form";
    }
}
