package ir.baharn.demobaharan.controller;

import ir.baharn.demobaharan.dto.PersonDTO;
import ir.baharn.demobaharan.service.DepartmentService;
import ir.baharn.demobaharan.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private PersonService personService;

    @Autowired
    private DepartmentService departmentService;

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN')")
    public String list(Model model, Principal principal) {
        model.addAttribute("username", principal.getName());
        model.addAttribute("persons", personService.getAll());
        return "persons-list";
    }



    @GetMapping("/new")
    @PreAuthorize("hasRole('ADMIN')")
    public String createForm(Model model , Principal principal) {
        model.addAttribute("username", principal.getName());
        model.addAttribute("person", new PersonDTO());
        model.addAttribute("departments", departmentService.getAll());
        model.addAttribute("isEdit", false);
        return "person-form";
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public String save(@ModelAttribute("person") PersonDTO person) {
        personService.save(person);
        return "redirect:/persons";
    }

    @GetMapping("/edit/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("person", personService.getById(id));
        model.addAttribute("departments", departmentService.getAll());
        model.addAttribute("isEdit", true);
        return "person-form";
    }

    @PostMapping("/update")
    @PreAuthorize("hasRole('ADMIN')")
    public String update(@ModelAttribute("person") PersonDTO person) {
        personService.update(person);
        return "redirect:/persons";
    }

    @GetMapping("/delete/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String delete(@PathVariable Long id) {
        personService.delete(id);
        return "redirect:/persons";
    }
}