package vn.codegym.case_study.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.case_study.model.Employee;

import java.util.List;

public interface EmployeeService {
    Page<Employee> findAll(Pageable pageable, String keyword);


    List<Employee> getList();

    Employee findById(Integer id);

    void save(Employee employee);

    void remove(Integer id);

}
