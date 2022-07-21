package com.codegym.controller;

import com.codegym.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {
    @Autowired
    private DictionaryService dictionaryService;

    @GetMapping
    public String showPage() {
        return "index";
    }

    @PostMapping
    public String translate(@RequestParam String txtSearch, Model model) {
        String result = dictionaryService.translate(txtSearch);
        model.addAttribute("result", result);
        return "index";
    }
}
