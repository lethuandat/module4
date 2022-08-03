package vn.codegym.case_study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class HomeController {
    @GetMapping("/home")
    public String showHomePage() {
        return "index";
    }

    @GetMapping("/myLogin")
    public String showLoginPage() {
        return "/login/myLogin";
    }

    @GetMapping("/access-denied")
    public String showErrorPage() {
        return "/login/403";
    }
}
