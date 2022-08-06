package vn.codegym.case_study.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class FacilityDto {
    private Integer id;

    @NotBlank(message = "*Không được để trống!")
    @Pattern(message = "*Không đúng định dạng", regexp = "^([A-Z\\p{L}]{1}[a-z\\p{L}]*)+(\\s([A-Z\\p{L}]{1}[a-z\\p{L}]*))*$")
    private String name;

    @NotBlank(message = "*Không được để trống!")
    private String area;

    @NotBlank(message = "*Không được để trống!")
    @Pattern(regexp = "[1-9]+\\d*", message = "*Phải nhập số và lớn hơn 0")
    private String cost;

    @NotBlank(message = "*Không được để trống!")
    private String maxPeople;

    @NotBlank(message = "*Không được để trống!")
    private String rentType;

    @NotBlank(message = "*Không được để trống!")
    private String facilityType;

    @NotBlank(message = "*Không được để trống!")
    private String standardRoom;

    @NotBlank(message = "*Không được để trống!")
    private String otherDescription;

    @NotBlank(message = "*Không được để trống!")
    @Pattern(regexp = "[1-9]+\\d*", message = "*Phải nhập số và lớn hơn 0")
    private String poolArea;

    @NotBlank(message = "*Không được để trống!")
    @Pattern(regexp = "[1-9]+\\d*", message = "*Phải nhập số và lớn hơn 0")
    private String numberFloor;

    @NotBlank(message = "*Không được để trống!")
    private String facilityFree;

    public FacilityDto() {
    }

    public FacilityDto(Integer id, String name, String area, String cost, String maxPeople, String rentType, String facilityType, String standardRoom, String otherDescription, String poolArea, String numberFloor, String facilityFree) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.cost = cost;
        this.maxPeople = maxPeople;
        this.rentType = rentType;
        this.facilityType = facilityType;
        this.standardRoom = standardRoom;
        this.otherDescription = otherDescription;
        this.poolArea = poolArea;
        this.numberFloor = numberFloor;
        this.facilityFree = facilityFree;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(String maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getRentType() {
        return rentType;
    }

    public void setRentType(String rentType) {
        this.rentType = rentType;
    }

    public String getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(String facilityType) {
        this.facilityType = facilityType;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getOtherDescription() {
        return otherDescription;
    }

    public void setOtherDescription(String otherDescription) {
        this.otherDescription = otherDescription;
    }

    public String getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(String poolArea) {
        this.poolArea = poolArea;
    }

    public String getNumberFloor() {
        return numberFloor;
    }

    public void setNumberFloor(String numberFloor) {
        this.numberFloor = numberFloor;
    }

    public String getFacilityFree() {
        return facilityFree;
    }

    public void setFacilityFree(String facilityFree) {
        this.facilityFree = facilityFree;
    }
}
