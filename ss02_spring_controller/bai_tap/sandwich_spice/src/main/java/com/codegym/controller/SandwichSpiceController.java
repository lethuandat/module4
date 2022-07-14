package com.codegym.controller;

import com.codegym.service.SandwichSpiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandwichSpiceController {
    @Autowired
    SandwichSpiceService sandwichSpiceService;

    @GetMapping
    public String showPage() {
        return "index";
    }

    @PostMapping
    public String addSpice(Model model, @RequestParam("condiment") String[] condiment) {
        String spice = sandwichSpiceService.save(condiment);
        model.addAttribute("spice", spice);
        return "index";
    }
}
