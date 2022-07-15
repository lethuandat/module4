package com.codegym.repository;

import com.codegym.model.MedicalDeclaration;

import java.util.List;

public interface MedicalDeclarationRepository {
    List<Integer> birthDayList();

    List<String> genderList();

    List<String> countryList();

    List<String> vehicleList();

    List<Integer> dayStartList();

    List<Integer> monthStartList();

    List<Integer> yearStartList();

    List<Integer> dayEndList();

    List<Integer> monthEndList();

    List<Integer> yearEndList();

    List<MedicalDeclaration> findAll();

    MedicalDeclaration findOne(String identity);

    void update(String identity, MedicalDeclaration medicalDeclaration);

    void save(MedicalDeclaration medicalDeclaration);
}
