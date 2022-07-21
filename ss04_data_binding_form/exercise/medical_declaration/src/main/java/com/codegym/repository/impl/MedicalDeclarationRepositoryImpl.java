package com.codegym.repository.impl;

import com.codegym.model.MedicalDeclaration;
import com.codegym.repository.MedicalDeclarationRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MedicalDeclarationRepositoryImpl implements MedicalDeclarationRepository {
    private final static List<Integer> birthDayList = new ArrayList<>();
    private final static List<String> genderList = new ArrayList<>();
    private final static List<String> countryList = new ArrayList<>();
    private final static List<String> vehicleList = new ArrayList<>();
    private final static List<Integer> dayStartList = new ArrayList<>();
    private final static List<Integer> monthStartList = new ArrayList<>();
    private final static List<Integer> yearStartList = new ArrayList<>();
    private final static List<Integer> dayEndList = new ArrayList<>();
    private final static List<Integer> monthEndList = new ArrayList<>();
    private final static List<Integer> yearEndList = new ArrayList<>();
    private final static List<MedicalDeclaration> medicalDeclarationList;

    static {
        birthDayList.add(1990);
        birthDayList.add(1991);
        birthDayList.add(1992);
        birthDayList.add(1993);
        birthDayList.add(1994);
        birthDayList.add(1995);

        genderList.add("Nam");
        genderList.add("Nữ");
        genderList.add("LGBT");

        countryList.add("Việt Nam");
        countryList.add("Trung Quốc");
        countryList.add("Hàn Quốc");

        vehicleList.add("Tàu bay");
        vehicleList.add("Tàu thuyền");
        vehicleList.add("Ô tô");
        vehicleList.add("Khác");

        dayStartList.add(1);
        dayStartList.add(2);
        dayStartList.add(3);
        dayStartList.add(4);
        dayStartList.add(5);
        dayStartList.add(6);
        dayStartList.add(7);
        dayStartList.add(8);
        dayStartList.add(9);
        dayStartList.add(10);
        dayStartList.add(11);
        dayStartList.add(12);
        dayStartList.add(13);
        dayStartList.add(14);
        dayStartList.add(15);
        dayStartList.add(16);
        dayStartList.add(17);
        dayStartList.add(18);
        dayStartList.add(19);
        dayStartList.add(20);
        dayStartList.add(21);
        dayStartList.add(22);
        dayStartList.add(23);
        dayStartList.add(24);
        dayStartList.add(25);
        dayStartList.add(26);
        dayStartList.add(27);
        dayStartList.add(28);
        dayStartList.add(29);
        dayStartList.add(30);
        dayStartList.add(31);

        monthStartList.add(1);
        monthStartList.add(2);
        monthStartList.add(3);
        monthStartList.add(4);
        monthStartList.add(5);
        monthStartList.add(6);
        monthStartList.add(7);
        monthStartList.add(8);
        monthStartList.add(9);
        monthStartList.add(10);
        monthStartList.add(11);
        monthStartList.add(12);

        yearStartList.add(2019);
        yearStartList.add(2020);
        yearStartList.add(2021);
        yearStartList.add(2022);

        dayEndList.add(1);
        dayEndList.add(2);
        dayEndList.add(3);
        dayEndList.add(4);
        dayEndList.add(5);
        dayEndList.add(6);
        dayEndList.add(7);
        dayEndList.add(8);
        dayEndList.add(9);
        dayEndList.add(10);
        dayEndList.add(11);
        dayEndList.add(12);
        dayEndList.add(13);
        dayEndList.add(14);
        dayEndList.add(15);
        dayEndList.add(16);
        dayEndList.add(17);
        dayEndList.add(18);
        dayEndList.add(19);
        dayEndList.add(20);
        dayEndList.add(21);
        dayEndList.add(22);
        dayEndList.add(23);
        dayEndList.add(24);
        dayEndList.add(25);
        dayEndList.add(26);
        dayEndList.add(27);
        dayEndList.add(28);
        dayEndList.add(29);
        dayEndList.add(30);
        dayEndList.add(31);

        monthEndList.add(1);
        monthEndList.add(2);
        monthEndList.add(3);
        monthEndList.add(4);
        monthEndList.add(5);
        monthEndList.add(6);
        monthEndList.add(7);
        monthEndList.add(8);
        monthEndList.add(9);
        monthEndList.add(10);
        monthEndList.add(11);
        monthEndList.add(12);

        yearEndList.add(2019);
        yearEndList.add(2020);
        yearEndList.add(2021);
        yearEndList.add(2022);

        medicalDeclarationList = new ArrayList<>();
        medicalDeclarationList.add(new MedicalDeclaration("LÊ VĂN NAM", 1990, "Nam", "Việt Nam", "204523841", "Ô tô", "VN123", 4, 15, 5, 2020, 30, 12, 2020, "Đà Nẵng"));
        medicalDeclarationList.add(new MedicalDeclaration("LÊ VĂN LONG", 1991, "Nam", "Việt Nam", "204523941", "Ô tô", "VN133", 4, 15, 5, 2020, 30, 12, 2020, "Quảng Nam"));
        medicalDeclarationList.add(new MedicalDeclaration("LÊ THỊ DIỄM", 1992, "Nữ", "Việt Nam", "204523831", "Ô tô", "VN523", 4, 15, 5, 2020, 30, 12, 2020, "Hà Nội"));
    }

    @Override
    public List<Integer> birthDayList() {
        return birthDayList;
    }

    @Override
    public List<String> genderList() {
        return genderList;
    }

    @Override
    public List<String> countryList() {
        return countryList;
    }

    @Override
    public List<String> vehicleList() {
        return vehicleList;
    }

    @Override
    public List<Integer> dayStartList() {
        return dayStartList;
    }

    @Override
    public List<Integer> monthStartList() {
        return monthStartList;
    }

    @Override
    public List<Integer> yearStartList() {
        return yearStartList;
    }

    @Override
    public List<Integer> dayEndList() {
        return dayEndList;
    }

    @Override
    public List<Integer> monthEndList() {
        return monthEndList;
    }

    @Override
    public List<Integer> yearEndList() {
        return yearEndList;
    }

    @Override
    public List<MedicalDeclaration> findAll() {
        return medicalDeclarationList;
    }

    @Override
    public MedicalDeclaration findOne(String identity) {
        MedicalDeclaration medicalDeclaration = null;

        for (MedicalDeclaration item : medicalDeclarationList) {
            if (item.getIdentity().equals(identity)) {
                medicalDeclaration = new MedicalDeclaration(item.getName(),
                        item.getBirthDay(),
                        item.getGender(),
                        item.getCountry(),
                        item.getIdentity(),
                        item.getVehicle(),
                        item.getNumberVehicle(),
                        item.getNumberSeat(),
                        item.getDayStart(),
                        item.getMonthStart(),
                        item.getYearStart(),
                        item.getDayEnd(),
                        item.getMonthEnd(),
                        item.getYearEnd(),
                        item.getInformationMove());
            }
        }
        return medicalDeclaration;
    }

    @Override
    public void update(String identity, MedicalDeclaration medicalDeclaration) {
        for (MedicalDeclaration item : medicalDeclarationList) {
            if (item.getIdentity().equals(identity)) {
                item.setName(medicalDeclaration.getName());
                item.setBirthDay(medicalDeclaration.getBirthDay());
                item.setGender(medicalDeclaration.getGender());
                item.setCountry(medicalDeclaration.getCountry());
                item.setVehicle(medicalDeclaration.getVehicle());
                item.setNumberVehicle(medicalDeclaration.getNumberVehicle());
                item.setNumberSeat(medicalDeclaration.getNumberSeat());
                item.setDayStart(medicalDeclaration.getDayStart());
                item.setMonthStart(medicalDeclaration.getMonthStart());
                item.setYearStart(medicalDeclaration.getYearStart());
                item.setDayEnd(medicalDeclaration.getDayEnd());
                item.setMonthEnd(medicalDeclaration.getMonthEnd());
                item.setYearEnd(medicalDeclaration.getYearEnd());
                item.setInformationMove(medicalDeclaration.getInformationMove());
            }
        }
    }

    @Override
    public void save(MedicalDeclaration medicalDeclaration) {
        medicalDeclarationList.add(medicalDeclaration);
    }
}
