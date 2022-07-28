package vn.codegym.case_study.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.case_study.model.AttachFacility;
import vn.codegym.case_study.repository.AttachFacilityRepository;
import vn.codegym.case_study.service.AttachFacilityService;

import java.util.List;

@Service
public class AttachFacilityServiceImpl implements AttachFacilityService {
    @Autowired
    AttachFacilityRepository attachFacilityRepository;

    @Override
    public List<AttachFacility> findAll() {
        return attachFacilityRepository.findAll();
    }
}
