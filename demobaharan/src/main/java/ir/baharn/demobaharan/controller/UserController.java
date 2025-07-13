package ir.baharn.demobaharan.controller;

import ir.baharn.demobaharan.model.*;

import ir.baharn.demobaharan.service.PersonService;
import ir.baharn.demobaharan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String createForm(Model model) {
        model.addAttribute("persons", personService.getAll());
        return "user-form";
    }

    @PostMapping("/new")
    public String saveUser(@RequestParam String username,
                           @RequestParam String password,
                           @RequestParam Long personId, @RequestParam(required = false) String role) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setPerson(personService.getEntityById(personId));
        if (role != null && !role.isEmpty()) {
            user.setRole(Role.valueOf(role));
        } else {

            String personRole = personService.getPersonRole(user.getPerson());
            switch (personRole) {
                case "STUDENT":
                    user.setRole(Role.STUDENT);
                    break;
                case "TEACHER":
                    user.setRole(Role.TEACHER);
                    break;
                default:
                    user.setRole(Role.ADMIN);
                    break;
            }
        }

        userService.save(user);
        return "redirect:/users/list";
    }

}
