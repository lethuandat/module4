package vn.codegym.validation_login_form.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/user")
    public String show(Model model){
        model.addAttribute("a","a");
        return "home";
    }
}
