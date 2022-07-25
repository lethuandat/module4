package vn.codegym.case_study.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import vn.codegym.case_study.model.Customer;

@Transactional
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Page<Customer> findAllByNameContainsOrEmailContainsOrAddressContains(String name, String email, String address, Pageable pageable);
}
