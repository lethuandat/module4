package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConvertController {
    @GetMapping("")
    public String showPage() {
        return "index";
    }

    @PostMapping("")
    public String convertCurrency(@RequestParam double rate, double usd, Model model) {
        double result = rate * usd;
        model.addAttribute("result", result);
        return "index";
    }
}
