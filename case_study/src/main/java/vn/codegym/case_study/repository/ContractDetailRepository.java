package vn.codegym.case_study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.case_study.model.ContractDetail;

public interface ContractDetailRepository extends JpaRepository<ContractDetail, Integer>{
}
