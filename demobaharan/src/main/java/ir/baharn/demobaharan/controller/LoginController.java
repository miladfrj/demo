package ir.baharn.demobaharan.controller;

import ir.baharn.demobaharan.model.User;
import ir.baharn.demobaharan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String loginPost(@RequestParam String username,
                            @RequestParam String password,
                            Model model) {

        User user = userService.login(username, password);

        if (user != null) {
            return "redirect:/role-selection";
        } else {
            model.addAttribute("error", "نام کاربری یا رمز عبور اشتباه است");
            return "login";
        }
    }
}

