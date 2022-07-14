package com.codegym.controller;

import com.codegym.service.ConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConvertController {
    @Autowired
    private ConvertService convertService;

    @GetMapping
    public String showPage() {
        return "index";
    }

    @PostMapping
    public String convertCurrency(@RequestParam double rate, double usd, Model model) {
        double result = convertService.convert(rate, usd);
        model.addAttribute("rate", rate);
        model.addAttribute("usd", usd);
        model.addAttribute("result", result);
        return "index";
    }
}
