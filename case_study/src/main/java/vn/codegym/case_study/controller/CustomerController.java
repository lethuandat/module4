package vn.codegym.case_study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.case_study.model.Customer;
import vn.codegym.case_study.model.CustomerType;
import vn.codegym.case_study.service.CustomerService;
import vn.codegym.case_study.service.CustomerTypeService;

import java.util.List;

@Controller
@RequestMapping("customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;
    @Autowired
    CustomerTypeService customerTypeService;

    @GetMapping
    public String showPage(@PageableDefault(value = 5) Pageable pageable, Model model) {
        Page<Customer> customerList = customerService.findAll(pageable);
        List<CustomerType> customerTypeList = customerTypeService.findAll();

        model.addAttribute("customerList", customerList);
        model.addAttribute("customerTypeList", customerTypeList);

        return "customer/list";
    }

    @GetMapping("/search")
    public String search(@PageableDefault(value = 5) Pageable pageable, String keyword, Model model) {
        Page<Customer> customerList = customerService.search(keyword, pageable);
        List<CustomerType> customerTypeList = customerTypeService.findAll();

        model.addAttribute("customerList", customerList);
        model.addAttribute("customerTypeList", customerTypeList);

        return "customer/list";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        List<CustomerType> customerTypeList = customerTypeService.findAll();
        model.addAttribute("customerTypeList", customerTypeList);
        model.addAttribute("customer", new Customer());
        return "/customer/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("customer") Customer customer, RedirectAttributes redirectAttributes) {
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("message", "Thêm mới thành công!");
        return "redirect:/customer";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable int id, Model model) {
        List<CustomerType> customerTypeList = customerTypeService.findAll();
        model.addAttribute("customer", customerService.findById(id));
        model.addAttribute("customerTypeList", customerTypeList);
        return "/customer/edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("customer") Customer customer, RedirectAttributes redirectAttributes) {
        customerService.save(customer);
        redirectAttributes.addFlashAttribute("message", "Cập nhật thành công!");
        return "redirect:/customer";
    }

    @GetMapping("delete")
    public String delete(@RequestParam int id) {
        customerService.remove(id);
        return "redirect:/customer";
    }
}
