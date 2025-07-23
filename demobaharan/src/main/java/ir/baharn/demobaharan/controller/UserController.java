package ir.baharn.demobaharan.controller;

import ir.baharn.demobaharan.dto.PersonDTO;
import ir.baharn.demobaharan.model.*;

import ir.baharn.demobaharan.service.PersonService;
import ir.baharn.demobaharan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private PersonService personService;

    @GetMapping("/list")
    public String listUsers(Model model) {
        model.addAttribute("users", userService.getAll());
        return "users-list";
    }


    @GetMapping("/new")
    public String createForm(Model model, @RequestParam(value = "role", required = false) String roleParam) {
        model.addAttribute("roles", Arrays.asList(Role.values()));
        model.addAttribute("persons", personService.getPersonsByRoleSafe(roleParam));
        return "user-form";
    }



    @GetMapping("/persons")
    @ResponseBody
    public List<PersonDTO> getPersonsByRole(@RequestParam String role) {
        return personService.getPersonsByRoleSafe(role);
    }



    @PostMapping("/new")
    public String saveUser(@RequestParam String username,
                           @RequestParam String password,
                           @RequestParam Long personId,
                           @RequestParam(required = false) String role) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setPerson(personService.getEntityById(personId));

        userService.assignRoleToUser(user, role);
        userService.save(user);
        return "redirect:/users/list";
    }


    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        userService.delete(id);
        return "redirect:/users/list";
    }


}
