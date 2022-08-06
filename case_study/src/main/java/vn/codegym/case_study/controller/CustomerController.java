package vn.codegym.case_study.controller;

import jdk.nashorn.internal.runtime.options.Option;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.case_study.dto.CustomerDto;
import vn.codegym.case_study.model.Customer;
import vn.codegym.case_study.model.CustomerType;
import vn.codegym.case_study.service.CustomerService;
import vn.codegym.case_study.service.CustomerTypeService;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;
    @Autowired
    CustomerTypeService customerTypeService;

    @GetMapping
    public String showPage(@PageableDefault(value = 5) Pageable pageable, @RequestParam Optional<String> keyword, Model model) {
        model.addAttribute("keyword", keyword.orElse(""));
        List<CustomerType> customerTypeList = customerTypeService.findAll();
        model.addAttribute("customerTypeList", customerTypeList);
        model.addAttribute("customerList", customerService.findAll(pageable, keyword.orElse("")));
        return "customer/list";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        List<CustomerType> customerTypeList = customerTypeService.findAll();
        model.addAttribute("customerTypeList", customerTypeList);
        model.addAttribute("customerDto", new CustomerDto());
        return "/customer/create";
    }

    @PostMapping("/create")
    public String create(@Validated @ModelAttribute("customerDto") CustomerDto customerDto, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasFieldErrors()) {
            List<CustomerType> customerTypeList = customerTypeService.findAll();
            model.addAttribute("customerTypeList", customerTypeList);
            return "/customer/create";
        }

        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);

        customer.setGender(Boolean.parseBoolean(customerDto.getGender()));
        customer.setBirthDay(LocalDate.parse(customerDto.getBirthDay()));
        customer.setCustomerType(new CustomerType(Integer.parseInt(customerDto.getCustomerType())));

        customerService.save(customer);
        redirectAttributes.addFlashAttribute("message", "Thêm mới thành công!");
        return "redirect:/customer";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable int id, Model model) {
        List<CustomerType> customerTypeList = customerTypeService.findAll();
        model.addAttribute("customerDto", customerService.findById(id));
        model.addAttribute("customerTypeList", customerTypeList);
        return "/customer/edit";
    }

    @PostMapping("/update")
    public String update(@Validated @ModelAttribute("customerDto") CustomerDto customerDto, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasFieldErrors()) {
            List<CustomerType> customerTypeList = customerTypeService.findAll();
            model.addAttribute("customerTypeList", customerTypeList);
            return "/customer/edit";
        }

        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);

        customer.setGender(Boolean.parseBoolean(customerDto.getGender()));
        customer.setBirthDay(LocalDate.parse(customerDto.getBirthDay()));
        customer.setCustomerType(new CustomerType(Integer.parseInt(customerDto.getCustomerType())));

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
