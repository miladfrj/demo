package ir.baharn.demobaharan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RoleSelectionController {

    @GetMapping("/role-selection")
    public String selectRole() {
        return "role-selection";
    }
}
