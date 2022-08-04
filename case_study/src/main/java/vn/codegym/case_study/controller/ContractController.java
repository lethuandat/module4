package vn.codegym.case_study.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.case_study.dto.ContractDto;
import vn.codegym.case_study.model.*;
import vn.codegym.case_study.service.*;

import java.util.List;

@Controller
@RequestMapping("contract")
public class ContractController {
    @Autowired
    ContractService contractService;

    @Autowired
    FacilityService facilityService;

    @Autowired
    CustomerService customerService;

    @Autowired
    ContractDetailService contractDetailService;

    @Autowired
    AttachFacilityService attachFacilityService;

    @Autowired
    EmployeeService employeeService;

    @GetMapping
    public String showPage(@PageableDefault(value = 1005) Pageable pageable, Model model) {
        Page<Contract> contractList = contractService.findAll(pageable);
        Page<Facility> facilityList = facilityService.findAll(pageable);
        Page<Customer> customerList = customerService.findAll(pageable);
        List<ContractDetail> contractDetailList = contractDetailService.findAll();
        List<AttachFacility> attachFacilityList = attachFacilityService.findAll();
        List<Double> totalMoneyList = contractService.getTotalMoney();

        model.addAttribute("contractList", contractList);
        model.addAttribute("facilityList", facilityList);
        model.addAttribute("customerList", customerList);
        model.addAttribute("contractDetailList", contractDetailList);
        model.addAttribute("attachFacilityList", attachFacilityList);
        model.addAttribute("totalMoneyList", totalMoneyList);

        return "contract/list";
    }

    @GetMapping("/create")
    public String createForm(@PageableDefault(value = 5) Pageable pageable, Model model) {
        Page<Facility> facilityList = facilityService.findAll(pageable);
        Page<Customer> customerList = customerService.findAll(pageable);
        Page<Employee> employeeList = employeeService.findAll(pageable);
        List<AttachFacility> attachFacilityList = attachFacilityService.findAll();

        model.addAttribute("facilityList", facilityList);
        model.addAttribute("customerList", customerList);
        model.addAttribute("employeeList", employeeList);
        model.addAttribute("attachFacilityList", attachFacilityList);

        model.addAttribute("contractDto", new ContractDto());

        return "/contract/create";
    }

    @PostMapping("/create")
    public String create(@PageableDefault(value = 5) Pageable pageable, @Validated @ModelAttribute("contractDto") ContractDto contractDto, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasFieldErrors()) {
            Page<Facility> facilityList = facilityService.findAll(pageable);
            Page<Customer> customerList = customerService.findAll(pageable);
            Page<Employee> employeeList = employeeService.findAll(pageable);

            model.addAttribute("facilityList", facilityList);
            model.addAttribute("customerList", customerList);
            model.addAttribute("employeeList", employeeList);

            return "/contract/create";
        }

        Contract contract = new Contract();
        BeanUtils.copyProperties(contractDto, contract);

        contract.setDeposit(Double.parseDouble(contractDto.getDeposit()));
        contract.setFacility(new Facility(Integer.parseInt(contractDto.getFacility())));
        contract.setCustomer(new Customer(Integer.parseInt(contractDto.getCustomer())));
        contract.setEmployee(new Employee(Integer.parseInt(contractDto.getEmployee())));

        contractService.save(contract);

        redirectAttributes.addFlashAttribute("message", "Thêm mới thành công!");
        return "redirect:/contract";
    }
}
