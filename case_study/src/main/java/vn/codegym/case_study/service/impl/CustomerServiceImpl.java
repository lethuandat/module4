package vn.codegym.case_study.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.case_study.model.Customer;
import vn.codegym.case_study.model.CustomerType;
import vn.codegym.case_study.repository.CustomerRepository;
import vn.codegym.case_study.service.CustomerService;

import java.util.Optional;
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public Optional<Customer> findById(Integer id) {
        return customerRepository.findById(id);
    }

    @Override
    public void save(Customer customer) {
        customer.setCustomerType((CustomerType) customer.getCustomerType() );
        customerRepository.save(customer);
    }

    @Override
    public void remove(Integer id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Page<Customer> search(String keyword, Pageable pageable) {
        return customerRepository.findAllByNameContainsOrEmailContainsOrAddressContains(keyword, keyword, keyword,pageable);
    }
}
