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

import java.time.LocalDate;
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
        List<Facility> facilityList = facilityService.getList();
        List<Customer> customerList = customerService.getList();
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
    public String createForm(Model model) {
        List<Facility> facilityList = facilityService.getList();
        List<Customer> customerList = customerService.getList();
        List<Employee> employeeList = employeeService.getList();
        List<AttachFacility> attachFacilityList = attachFacilityService.findAll();

        model.addAttribute("facilityList", facilityList);
        model.addAttribute("customerList", customerList);
        model.addAttribute("employeeList", employeeList);
        model.addAttribute("attachFacilityList", attachFacilityList);

        model.addAttribute("contractDto", new ContractDto());

        return "/contract/create";
    }

    @PostMapping("/create")
    public String create(@Validated @ModelAttribute("contractDto") ContractDto contractDto, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasFieldErrors()) {
            List<Facility> facilityList = facilityService.getList();
            List<Customer> customerList = customerService.getList();
            List<Employee> employeeList = employeeService.getList();

            model.addAttribute("facilityList", facilityList);
            model.addAttribute("customerList", customerList);
            model.addAttribute("employeeList", employeeList);

            return "/contract/create";
        }

        Contract contract = new Contract();
        BeanUtils.copyProperties(contractDto, contract);

        contract.setStartDate(LocalDate.parse(contractDto.getStartDate()));
        contract.setEndDate(LocalDate.parse(contractDto.getEndDate()));
        contract.setDeposit(Double.parseDouble(contractDto.getDeposit()));
        contract.setFacility(new Facility(Integer.parseInt(contractDto.getFacility())));
        contract.setCustomer(new Customer(Integer.parseInt(contractDto.getCustomer())));
        contract.setEmployee(new Employee(Integer.parseInt(contractDto.getEmployee())));

        contractService.save(contract);

        redirectAttributes.addFlashAttribute("message", "Thêm mới thành công!");
        return "redirect:/contract";
    }
}
