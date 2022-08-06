package vn.codegym.case_study.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.codegym.case_study.dto.EmployeeDto;
import vn.codegym.case_study.model.*;
import vn.codegym.case_study.service.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
@CrossOrigin
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

    @Autowired
    UserService userService;

    @GetMapping
    public String showPage(@PageableDefault(value = 5) Pageable pageable, @RequestParam Optional<String> keyword, Model model) {
        Page<Employee> employeeList = employeeService.findAll(pageable, keyword.orElse(""));
        List<Division> divisionList = divisionService.findAll();
        List<Position> positionList = positionService.findAll();
        List<EducationDegree> educationDegreeList = educationDegreeService.findAll();
        List<User> userList = userService.findAll();

        model.addAttribute("employeeList", employeeList);
        model.addAttribute("divisionList", divisionList);
        model.addAttribute("positionList", positionList);
        model.addAttribute("educationDegreeList", educationDegreeList);
        model.addAttribute("userList", userList);
        model.addAttribute("keyword", keyword.orElse(""));

        return "employee/list";
    }

    //  Thêm mới = AJAX 22:40 04-08-2022
    @PostMapping("/create")
    public ResponseEntity create(@RequestBody EmployeeDto employeeDto) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto, employee);

        employee.setSalary(Double.parseDouble(employeeDto.getSalary()));
        employee.setBirthDay(LocalDate.parse(employeeDto.getBirthDay()));
        employee.setPosition(new Position(Integer.parseInt(employeeDto.getPosition())));
        employee.setEducationDegree(new EducationDegree(Integer.parseInt(employeeDto.getEducationDegree())));
        employee.setDivision(new Division(Integer.parseInt(employeeDto.getDivision())));
        employee.setUsername(new User(employeeDto.getUsername()));

        employeeService.save(employee);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    //  Tìm 1 employee = AJAX 09:00 05-08-2022
    @GetMapping("/{id}")
    public ResponseEntity findOne(@PathVariable Integer id) {
        return new ResponseEntity<>(employeeService.findById(id), HttpStatus.OK);
    }

    //  Cập nhật = AJAX 09:10 05-08-2022
    @PutMapping("/update/{id}")
    public ResponseEntity<Employee> update(@PathVariable Integer id, @RequestBody EmployeeDto employeeDto) {
        Employee currentEmployee = employeeService.findById(id);

        if (currentEmployee == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        currentEmployee.setBirthDay(LocalDate.parse(employeeDto.getBirthDay()));

        currentEmployee.setSalary(Double.parseDouble(employeeDto.getSalary()));

        currentEmployee.setPosition(new Position(Integer.parseInt(employeeDto.getPosition())));

        currentEmployee.setEducationDegree(new EducationDegree(Integer.parseInt(employeeDto.getEducationDegree())));

        currentEmployee.setDivision(new Division(Integer.parseInt(employeeDto.getDivision())));

        employeeService.save(currentEmployee);

        return new ResponseEntity<>(currentEmployee, HttpStatus.OK);

    }

    @GetMapping("delete")
    public String delete(@RequestParam int id) {
        employeeService.remove(id);
        return "redirect:/employee";
    }
}
