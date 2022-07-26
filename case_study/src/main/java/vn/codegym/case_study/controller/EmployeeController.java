package vn.codegym.case_study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.case_study.model.Division;
import vn.codegym.case_study.model.EducationDegree;
import vn.codegym.case_study.model.Employee;
import vn.codegym.case_study.model.Position;
import vn.codegym.case_study.service.DivisionService;
import vn.codegym.case_study.service.EducationDegreeService;
import vn.codegym.case_study.service.EmployeeService;
import vn.codegym.case_study.service.PositionService;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @Autowired
    DivisionService divisionService;

    @Autowired
    PositionService positionService;

    @Autowired
    EducationDegreeService educationDegreeService;

    @GetMapping
    public String showPage(@PageableDefault(value = 5) Pageable pageable, Model model) {
        Page<Employee> employeeList = employeeService.findAll(pageable);
        List<Division> divisionList = divisionService.findAll();
        List<Position> positionList = positionService.findAll();
        List<EducationDegree> educationDegreeList = educationDegreeService.findAll();

        model.addAttribute("employeeList", employeeList);
        model.addAttribute("divisionList", divisionList);
        model.addAttribute("positionList", positionList);
        model.addAttribute("educationDegreeList", educationDegreeList);

        return "employee/list";
    }

    @GetMapping("/search")
    public String search(@PageableDefault(value = 5) Pageable pageable, String keyword, Model model) {
        Page<Employee> employeeList = employeeService.search(keyword, pageable);
        List<Division> divisionList = divisionService.findAll();
        List<Position> positionList = positionService.findAll();
        List<EducationDegree> educationDegreeList = educationDegreeService.findAll();

        model.addAttribute("employeeList", employeeList);
        model.addAttribute("divisionList", divisionList);
        model.addAttribute("positionList", positionList);
        model.addAttribute("educationDegreeList", educationDegreeList);

        return "employee/list";
    }

    @PostMapping("/create")
    public String create(@RequestParam("newName") String name, @RequestParam("newBirthDay") String birthDay, @RequestParam("newIdentity") String idCard, @RequestParam("newSalary") Double salary, @RequestParam("newPhone") String phone, @RequestParam("newEmail") String email, @RequestParam("newAddress") String address, @RequestParam("newPosition") Position position, @RequestParam("newEducationDegree") EducationDegree educationDegree, @RequestParam("newDivision") Division division, RedirectAttributes redirectAttributes) {
        employeeService.save(new Employee(name, birthDay, idCard, salary, phone, email, address, position, educationDegree, division, null));
        redirectAttributes.addFlashAttribute("message", "Thêm mới thành công!");
        return "redirect:/employee";
    }

    @PostMapping("/update")
    public String update(@RequestParam("id") Integer id, @RequestParam("name") String name, @RequestParam("birthDay") String birthDay, @RequestParam("idCard") String idCard, @RequestParam("salary") Double salary, @RequestParam("phone") String phone, @RequestParam("email") String email, @RequestParam("address") String address, @RequestParam("position") Position position, @RequestParam("educationDegree") EducationDegree educationDegree, @RequestParam("division") Division division, RedirectAttributes redirectAttributes) {
        Employee employee = employeeService.findById(id);
        employee.setName(name);
        employee.setBirthDay(birthDay);
        employee.setIdCard(idCard);
        employee.setSalary(salary);
        employee.setPhone(phone);
        employee.setEmail(email);
        employee.setAddress(address);
        employee.setPosition(position);
        employee.setEducationDegree(educationDegree);
        employee.setDivision(division);
        employeeService.save(employee);
        redirectAttributes.addFlashAttribute("message", "Cập nhật thành công!");
        return "redirect:/employee";
    }

    @GetMapping("delete")
    public String delete(@RequestParam int id) {
        employeeService.remove(id);
        return "redirect:/employee";
    }
}
