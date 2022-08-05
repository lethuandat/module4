package vn.codegym.case_study.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.case_study.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    Page<Customer> findAll(Pageable pageable, String keyword);

    List<Customer> getList();

    Optional<Customer> findById(Integer id);

    void save(Customer customer);

    void remove(Integer id);

}
