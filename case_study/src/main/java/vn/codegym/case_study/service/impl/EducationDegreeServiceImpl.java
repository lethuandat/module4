package vn.codegym.case_study.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.case_study.model.EducationDegree;
import vn.codegym.case_study.repository.EducationDegreeRepository;
import vn.codegym.case_study.service.EducationDegreeService;

import java.util.List;

@Service
public class EducationDegreeServiceImpl implements EducationDegreeService {
    @Autowired
    EducationDegreeRepository educationDegreeRepository;

    @Override
    public List<EducationDegree> findAll() {
        return educationDegreeRepository.findAll();
    }
}
