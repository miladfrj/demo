package ir.baharn.demobaharan.controller;

import ir.baharn.demobaharan.model.User;
import ir.baharn.demobaharan.repository.UserRepository;
import ir.baharn.demobaharan.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model, HttpSession session) {
        List<User> users = userRepository.existsByUsername(username);
        if (users.isEmpty()) {
            model.addAttribute("error", "نام کاربری یا رمز عبور اشتباه است");
            return "login";
        }
        // مقایسه ساده پسورد
        List<User> matchedUsers = users.stream()
                .filter(u -> u.getPassword().equals(password))
                .toList();

        if (matchedUsers.isEmpty()) {
            model.addAttribute("error", "نام کاربری یا رمز عبور اشتباه است");
            return "login";
        }
        if (matchedUsers.size() == 1) {
            session.setAttribute("user", matchedUsers.get(0));
            session.setAttribute("role", matchedUsers.get(0).getRole());
            return "redirect:/home";
        } else {
            model.addAttribute("users", matchedUsers);
            return "role-selection";
        }
    }

    @PostMapping("/select-role")
    public String selectRole(@RequestParam Long userId, HttpSession session) {
        User user = userRepository.findById(userId).orElseThrow();
        session.setAttribute("user", user);
        session.setAttribute("role", user.getRole());
        return "redirect:/home";
    }


}

