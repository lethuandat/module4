package vn.codegym.case_study.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.case_study.model.Employee;

public interface EmployeeService {
    Page<Employee> findAll(Pageable pageable);

    Employee findById(Integer id);

    void save(Employee employee);

    void remove(Integer id);

    Page<Employee> search(String keyword, Pageable pageable);
}
