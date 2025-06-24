package ir.baharn.demobaharan.controller;

import ir.baharn.demobaharan.dto.PersonDTO;
import ir.baharn.demobaharan.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("persons", personService.getAll());
        return "persons-list";  // اسم فایل thymeleaf
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("person", new PersonDTO());
        model.addAttribute("isEdit", false);
        return "person-form";
    }

    @PostMapping
    public String save(@ModelAttribute("person") PersonDTO person) {
        personService.save(person);
        return "redirect:/persons";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("person", personService.getById(id));
        model.addAttribute("isEdit", true);
        return "person-form";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("person") PersonDTO person) {
        personService.update(person);
        return "redirect:/persons";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        personService.delete(id);
        return "redirect:/persons";
    }
}





/*
package ir.baharn.demobaharan.controller;

import ir.baharn.demobaharan.dto.PersonDTO;
import ir.baharn.demobaharan.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("persons" , personService.getAll());
        return "persons-list";
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("person", new PersonDTO());
        return "person-form.html";
    }

    @PostMapping
    public String save(@ModelAttribute("person") PersonDTO person) {
        personService.save(person);
        return "redirect:/persons";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("person", personService.getById(id));
        return "person-form.html";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("person") PersonDTO person) {
        personService.update(person);
        return "redirect:/persons";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        personService.delete(id);
        return "redirect:/persons";
    }

}
*/
