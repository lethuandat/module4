package vn.codegym.case_study.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import vn.codegym.case_study.model.Customer;

@Transactional
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query(value = "select * from customer where customer_name like :keyword or customer_email like :keyword or customer_address like :keyword", nativeQuery = true)
    Page<Customer> findAll(Pageable pageable, @Param("keyword") String keyword);
}
