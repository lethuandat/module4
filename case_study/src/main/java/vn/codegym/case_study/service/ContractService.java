package vn.codegym.case_study.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.case_study.model.Contract;

import java.util.Optional;

public interface ContractService {
    Page<Contract> findAll(Pageable pageable);

    Optional<Contract> findById(Integer id);

    void save(Contract contract);
}
