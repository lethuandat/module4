package com.codegym.controller;

import com.codegym.model.Email;
import com.codegym.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class EmailController {
    @Autowired
    EmailService emailService;

    @GetMapping("/display")
    public ModelAndView showList() {
        ModelAndView modelAndView = new ModelAndView("display");
        List<Email> emailList = emailService.findAll();
        modelAndView.addObject("emailList", emailList);
        return modelAndView;
    }

    @GetMapping("/update")
    public ModelAndView showUpdate(@RequestParam Integer id) {
        ModelAndView modelAndView = new ModelAndView("update");
        modelAndView.addObject("email", emailService.findOne(id));
        modelAndView.addObject("languageArr", emailService.showLanguage());
        modelAndView.addObject("pageSizeArr", emailService.showPageSize());
        return modelAndView;
    }

    @PostMapping("/update")
    public String updateEmail(@ModelAttribute("email") Email email) {
        emailService.save(email.getId(), email);
        return "redirect:/display";
    }
}
