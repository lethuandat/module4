package vn.codegym.case_study.dto;

import vn.codegym.case_study.model.FacilityType;
import vn.codegym.case_study.model.RentType;

import javax.validation.constraints.*;

public class FacilityDto {
    private Integer id;

    @NotBlank(message = "*Không được để trống!")
    @Pattern(message = "*Không đúng định dạng (VD: Lê Văn An)", regexp = "^([A-Z\\p{L}]{1}[a-z\\p{L}]*)+(\\s([A-Z\\p{L}]{1}[a-z\\p{L}]*))*$")
    private String name;


    @Min(value = 1, message = "*Phải nhập số > 0")
    private Integer area;


    @Min(value = 1, message = "*Phải nhập số > 0")
    private Double cost;

    @Min(value = 1, message = "*Phải nhập số > 0")
    private Integer maxPeople;

    @NotNull(message = "*Không được để trống!")
    private RentType rentType;

    @NotNull(message = "*Không được để trống!")
    private FacilityType facilityType;

    @NotBlank(message = "*Không được để trống!")
    private String standardRoom;

    @NotBlank(message = "*Không được để trống!")
    private String otherDescription;


    @Min(value = 1, message = "*Phải nhập số > 0")
    private Double poolArea;


    @Min(value = 1, message = "*Phải nhập số > 0")
    private Integer numberFloor;

    @NotBlank(message = "*Không được để trống!")
    private String facilityFree;

    public FacilityDto() {
    }

    public FacilityDto(Integer id, String name, Integer area, Double cost, Integer maxPeople, RentType rentType, FacilityType facilityType, String standardRoom, String otherDescription, Double poolArea, Integer numberFloor, String facilityFree) {
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

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Integer getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(Integer maxPeople) {
        this.maxPeople = maxPeople;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public FacilityType getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(FacilityType facilityType) {
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

    public Double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(Double poolArea) {
        this.poolArea = poolArea;
    }

    public Integer getNumberFloor() {
        return numberFloor;
    }

    public void setNumberFloor(Integer numberFloor) {
        this.numberFloor = numberFloor;
    }

    public String getFacilityFree() {
        return facilityFree;
    }

    public void setFacilityFree(String facilityFree) {
        this.facilityFree = facilityFree;
    }
}
