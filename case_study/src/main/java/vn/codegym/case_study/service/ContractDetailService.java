package vn.codegym.case_study.service;

import vn.codegym.case_study.model.ContractDetail;

import java.util.List;

public interface ContractDetailService {
    List<ContractDetail> findAll();

    void save(ContractDetail contractDetail);
}
