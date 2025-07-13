package ir.baharn.demobaharan.controller;

import ir.baharn.demobaharan.model.User;
import ir.baharn.demobaharan.repository.UserRepository;
import ir.baharn.demobaharan.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String loginPage(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("user") User user, Model model , HttpSession session) {
        Optional<User> foundUser = userService.login(user.getUsername(), user.getPassword());
        if (foundUser.isPresent()) {
            session.setAttribute("user", foundUser);
            session.setAttribute("role", foundUser.get().getRole());
            return "redirect:/home";
        } else {
            model.addAttribute("loginError", "نام کاربری یا رمز عبور اشتباه است");
            return "login";
        }
    }
    }






