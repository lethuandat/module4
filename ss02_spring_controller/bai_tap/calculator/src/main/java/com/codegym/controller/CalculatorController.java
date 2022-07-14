package com.codegym.controller;

import com.codegym.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @Autowired
    private CalculatorService calculatorService;

    @GetMapping
    public String showPage() {
        return "index";
    }

    @PostMapping
    public String calculate(@RequestParam double firstOperand, double secondOperand, char operator, Model model) {
        double result = calculatorService.calculate(firstOperand, secondOperand, operator);
        model.addAttribute("result", result);
        return "index";
    }
}
