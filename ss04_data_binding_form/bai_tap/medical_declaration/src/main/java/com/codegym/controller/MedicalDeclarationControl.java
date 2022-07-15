package com.codegym.controller;

import com.codegym.model.MedicalDeclaration;
import com.codegym.service.MedicalDeclarationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class MedicalDeclarationControl {
    @Autowired
    MedicalDeclarationService medicalDeclarationService;

    @GetMapping("/display")
    public ModelAndView showPage() {
        ModelAndView modelAndView = new ModelAndView("display");

        List<MedicalDeclaration> medicalDeclarationList = medicalDeclarationService.findAll();

        modelAndView.addObject("medicalDeclarationList", medicalDeclarationList);

        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreatePage() {
        ModelAndView modelAndView = new ModelAndView("create");

        modelAndView.addObject("medicalDeclaration", new MedicalDeclaration());

        modelAndView.addObject("birthDay", medicalDeclarationService.birthDayList());

        modelAndView.addObject("gender", medicalDeclarationService.genderList());

        modelAndView.addObject("country", medicalDeclarationService.countryList());

        modelAndView.addObject("vehicle", medicalDeclarationService.vehicleList());

        modelAndView.addObject("dayStart", medicalDeclarationService.dayStartList());

        modelAndView.addObject("monthStart", medicalDeclarationService.monthStartList());

        modelAndView.addObject("yearStart", medicalDeclarationService.yearStartList());

        modelAndView.addObject("dayEnd", medicalDeclarationService.dayEndList());

        modelAndView.addObject("monthEnd", medicalDeclarationService.monthEndList());

        modelAndView.addObject("yearEnd", medicalDeclarationService.yearEndList());

        modelAndView.addObject("medicalDeclaration", new MedicalDeclaration());

        return modelAndView;
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("medicalDeclaration") MedicalDeclaration medicalDeclaration, RedirectAttributes redirectAttributes) {
        medicalDeclarationService.save(medicalDeclaration);
        redirectAttributes.addFlashAttribute("message", "Thêm mới thành công");
        return "redirect:/display";
    }

    @GetMapping("/update")
    public ModelAndView showUpdatePage(@RequestParam String identity) {
        ModelAndView modelAndView = new ModelAndView("update");

        modelAndView.addObject("medicalDeclaration", new MedicalDeclaration());

        modelAndView.addObject("birthDay", medicalDeclarationService.birthDayList());

        modelAndView.addObject("gender", medicalDeclarationService.genderList());

        modelAndView.addObject("country", medicalDeclarationService.countryList());

        modelAndView.addObject("vehicle", medicalDeclarationService.vehicleList());

        modelAndView.addObject("dayStart", medicalDeclarationService.dayStartList());

        modelAndView.addObject("monthStart", medicalDeclarationService.monthStartList());

        modelAndView.addObject("yearStart", medicalDeclarationService.yearStartList());

        modelAndView.addObject("dayEnd", medicalDeclarationService.dayEndList());

        modelAndView.addObject("monthEnd", medicalDeclarationService.monthEndList());

        modelAndView.addObject("yearEnd", medicalDeclarationService.yearEndList());

        modelAndView.addObject("medicalDeclaration", medicalDeclarationService.findOne(identity));

        return modelAndView;
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("medicalDeclaration") MedicalDeclaration medicalDeclaration, RedirectAttributes redirectAttributes) {
        medicalDeclarationService.update(medicalDeclaration.getIdentity(), medicalDeclaration);
        redirectAttributes.addFlashAttribute("message", "Cập nhật thành công");
        return "redirect:/display";
    }
}
