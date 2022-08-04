package vn.codegym.case_study.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class ContractDto {
    private Integer id;

    @NotBlank(message = "*Không được để trống!")
    private String startDate;

    @NotBlank(message = "*Không được để trống!")
    private String endDate;

    @NotBlank(message = "*Không được để trống!")
    @Pattern(regexp = "[1-9]+\\d*", message = "*Phải nhập số và lớn hơn 0")
    private String deposit;

    @NotBlank(message = "*Không được để trống!")
    private String employee;

    @NotBlank(message = "*Không được để trống!")
    private String customer;

    @NotBlank(message = "*Không được để trống!")
    private String facility;

    public ContractDto() {
    }

    public ContractDto(Integer id, String startDate, String endDate, String deposit, String employee, String customer, String facility) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.deposit = deposit;
        this.employee = employee;
        this.customer = customer;
        this.facility = facility;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getDeposit() {
        return deposit;
    }

    public void setDeposit(String deposit) {
        this.deposit = deposit;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getFacility() {
        return facility;
    }

    public void setFacility(String facility) {
        this.facility = facility;
    }
}
