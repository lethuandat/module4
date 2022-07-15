package com.codegym.service.impl;

import com.codegym.model.MedicalDeclaration;
import com.codegym.repository.MedicalDeclarationRepository;
import com.codegym.service.MedicalDeclarationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalDeclarationServiceImpl implements MedicalDeclarationService {
    @Autowired
    MedicalDeclarationRepository medicalDeclarationRepository;

    @Override
    public List<Integer> birthDayList() {
        return medicalDeclarationRepository.birthDayList();
    }

    @Override
    public List<String> genderList() {
        return medicalDeclarationRepository.genderList();
    }

    @Override
    public List<String> countryList() {
        return medicalDeclarationRepository.countryList();
    }

    @Override
    public List<String> vehicleList() {
        return medicalDeclarationRepository.vehicleList();
    }

    @Override
    public List<Integer> dayStartList() {
        return medicalDeclarationRepository.dayStartList();
    }

    @Override
    public List<Integer> monthStartList() {
        return medicalDeclarationRepository.monthStartList();
    }

    @Override
    public List<Integer> yearStartList() {
        return medicalDeclarationRepository.yearStartList();
    }

    @Override
    public List<Integer> dayEndList() {
        return medicalDeclarationRepository.dayEndList();
    }

    @Override
    public List<Integer> monthEndList() {
        return medicalDeclarationRepository.monthEndList();
    }

    @Override
    public List<Integer> yearEndList() {
        return medicalDeclarationRepository.yearEndList();
    }

    @Override
    public List<MedicalDeclaration> findAll() {
        return medicalDeclarationRepository.findAll();
    }

    @Override
    public MedicalDeclaration findOne(String identity) {
        return medicalDeclarationRepository.findOne(identity);
    }

    @Override
    public void update(String identity, MedicalDeclaration medicalDeclaration) {
        medicalDeclarationRepository.update(identity, medicalDeclaration);
    }

    @Override
    public void save(MedicalDeclaration medicalDeclaration) {
        medicalDeclarationRepository.save(medicalDeclaration);
    }


}
