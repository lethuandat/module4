package vn.codegym.case_study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.case_study.model.Facility;
import vn.codegym.case_study.model.FacilityType;
import vn.codegym.case_study.model.RentType;
import vn.codegym.case_study.service.FacilityService;
import vn.codegym.case_study.service.FacilityTypeService;
import vn.codegym.case_study.service.RentTypeService;

import java.util.List;

@Controller
@RequestMapping("/facility")
public class FacilityController {
    @Autowired
    FacilityService facilityService;

    @Autowired
    FacilityTypeService facilityTypeService;

    @Autowired
    RentTypeService rentTypeService;

    @GetMapping
    public String showPage(@PageableDefault(value = 5) Pageable pageable, Model model) {
        Page<Facility> facilityList = facilityService.findAll(pageable);
        List<RentType> rentTypeList = rentTypeService.findAll();
        List<FacilityType> facilityTypeList = facilityTypeService.findAll();

        model.addAttribute("facilityList", facilityList);
        model.addAttribute("rentTypeList", rentTypeList);
        model.addAttribute("facilityTypeList", facilityTypeList);

        return "facility/list";
    }

    @GetMapping("/search")
    public String search(@PageableDefault(value = 5) Pageable pageable, String keyword, Model model) {
        Page<Facility> facilityList = facilityService.search(keyword, pageable);
        List<RentType> rentTypeList = rentTypeService.findAll();
        List<FacilityType> facilityTypeList = facilityTypeService.findAll();

        model.addAttribute("facilityList", facilityList);
        model.addAttribute("rentTypeList", rentTypeList);
        model.addAttribute("facilityTypeList", facilityTypeList);

        return "facility/list";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        List<RentType> rentTypeList = rentTypeService.findAll();
        List<FacilityType> facilityTypeList = facilityTypeService.findAll();

        model.addAttribute("rentTypeList", rentTypeList);
        model.addAttribute("facilityTypeList", facilityTypeList);

        model.addAttribute("facility", new Facility());
        return "/facility/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("facility") Facility facility, RedirectAttributes redirectAttributes) {
        facilityService.save(facility);
        redirectAttributes.addFlashAttribute("message", "Thêm mới thành công!");
        return "redirect:/facility";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable int id, Model model) {
        List<RentType> rentTypeList = rentTypeService.findAll();
        List<FacilityType> facilityTypeList = facilityTypeService.findAll();

        model.addAttribute("rentTypeList", rentTypeList);
        model.addAttribute("facilityTypeList", facilityTypeList);

        model.addAttribute("facility", facilityService.findById(id));
        return "/facility/edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("facility") Facility facility, RedirectAttributes redirectAttributes) {
        facilityService.save(facility);
        redirectAttributes.addFlashAttribute("message", "Cập nhật thành công!");
        return "redirect:/facility";
    }

    @GetMapping("delete")
    public String delete(@RequestParam int id) {
        facilityService.remove(id);
        return "redirect:/facility";
    }

}
