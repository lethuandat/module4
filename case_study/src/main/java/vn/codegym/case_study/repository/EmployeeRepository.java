package vn.codegym.case_study.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.codegym.case_study.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    @Query(value = "select * from employee where name like :keyword or email like :keyword or address like :keyword", nativeQuery = true)
    Page<Employee> findAll(Pageable pageable, @Param("keyword") String keyword);
}
