package vn.codegym.case_study.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.case_study.model.Customer;

import java.util.Optional;

public interface CustomerService {
    Page<Customer> findAll(Pageable pageable);

    Optional<Customer> findById(Integer id);

    void save(Customer customer);

    void remove(Integer id);

    Page<Customer> search(String keyword, Pageable pageable);
}
