package com.codegym.model;

public class MedicalDeclaration {
    private String name;
    private Integer birthDay;
    private String gender;
    private String country;
    private String identity;
    private String vehicle;
    private String numberVehicle;
    private Integer numberSeat;
    private Integer dayStart;
    private Integer monthStart;
    private Integer yearStart;
    private Integer dayEnd;
    private Integer monthEnd;
    private Integer yearEnd;
    private String informationMove;

    public MedicalDeclaration() {
    }

    public MedicalDeclaration(String name, Integer birthDay, String gender, String country, String identity, String vehicle, String numberVehicle, Integer numberSeat, Integer dayStart, Integer monthStart, Integer yearStart, Integer dayEnd, Integer monthEnd, Integer yearEnd, String informationMove) {
        this.name = name;
        this.birthDay = birthDay;
        this.gender = gender;
        this.country = country;
        this.identity = identity;
        this.vehicle = vehicle;
        this.numberVehicle = numberVehicle;
        this.numberSeat = numberSeat;
        this.dayStart = dayStart;
        this.monthStart = monthStart;
        this.yearStart = yearStart;
        this.dayEnd = dayEnd;
        this.monthEnd = monthEnd;
        this.yearEnd = yearEnd;
        this.informationMove = informationMove;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Integer birthDay) {
        this.birthDay = birthDay;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public String getNumberVehicle() {
        return numberVehicle;
    }

    public void setNumberVehicle(String numberVehicle) {
        this.numberVehicle = numberVehicle;
    }

    public Integer getNumberSeat() {
        return numberSeat;
    }

    public void setNumberSeat(Integer numberSeat) {
        this.numberSeat = numberSeat;
    }

    public Integer getDayStart() {
        return dayStart;
    }

    public void setDayStart(Integer dayStart) {
        this.dayStart = dayStart;
    }

    public Integer getMonthStart() {
        return monthStart;
    }

    public void setMonthStart(Integer monthStart) {
        this.monthStart = monthStart;
    }

    public Integer getYearStart() {
        return yearStart;
    }

    public void setYearStart(Integer yearStart) {
        this.yearStart = yearStart;
    }

    public String getInformationMove() {
        return informationMove;
    }

    public void setInformationMove(String informationMove) {
        this.informationMove = informationMove;
    }

    public Integer getDayEnd() {
        return dayEnd;
    }

    public void setDayEnd(Integer dayEnd) {
        this.dayEnd = dayEnd;
    }

    public Integer getMonthEnd() {
        return monthEnd;
    }

    public void setMonthEnd(Integer monthEnd) {
        this.monthEnd = monthEnd;
    }

    public Integer getYearEnd() {
        return yearEnd;
    }

    public void setYearEnd(Integer yearEnd) {
        this.yearEnd = yearEnd;
    }

    @Override
    public String toString() {
        return "MedicalDeclaration{" +
                "name='" + name + '\'' +
                ", birthDay=" + birthDay +
                ", gender='" + gender + '\'' +
                ", country='" + country + '\'' +
                ", identity='" + identity + '\'' +
                ", vehicle='" + vehicle + '\'' +
                ", numberVehicle='" + numberVehicle + '\'' +
                ", numberSeat=" + numberSeat +
                ", dayStart=" + dayStart +
                ", monthStart=" + monthStart +
                ", yearStart=" + yearStart +
                ", dayEnd=" + dayEnd +
                ", monthEnd=" + monthEnd +
                ", yearEnd=" + yearEnd +
                ", informationMove='" + informationMove + '\'' +
                '}';
    }
}
