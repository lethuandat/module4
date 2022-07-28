package vn.codegym.case_study.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.case_study.model.FacilityType;
import vn.codegym.case_study.repository.FacilityTypeRepository;
import vn.codegym.case_study.service.FacilityTypeService;

import java.util.List;

@Service
public class FacilityTypeServiceImpl implements FacilityTypeService {
    @Autowired
    FacilityTypeRepository facilityTypeRepository;

    @Override
    public List<FacilityType> findAll() {
        return facilityTypeRepository.findAll();
    }
}
