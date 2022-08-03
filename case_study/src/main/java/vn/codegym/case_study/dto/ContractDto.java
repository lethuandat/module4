package vn.codegym.case_study.dto;

import vn.codegym.case_study.model.Customer;
import vn.codegym.case_study.model.Employee;
import vn.codegym.case_study.model.Facility;

import javax.validation.constraints.*;

public class ContractDto {
    private Integer id;

    @NotBlank(message = "*Không được để trống!")
    private String startDate;

    @NotBlank(message = "*Không được để trống!")
    private String endDate;

    @Min(value = 0, message = "*Phải nhập số >= 0")
    private Double deposit;

    @NotNull(message = "*Không được để trống!")
    private Employee employee;

    @NotNull(message = "*Không được để trống!")
    private Customer customer;

    @NotNull(message = "*Không được để trống!")
    private Facility facility;

    public ContractDto() {
    }

    public ContractDto(Integer id, String startDate, String endDate, Double deposit, Employee employee, Customer customer, Facility facility) {
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

    public Double getDeposit() {
        return deposit;
    }

    public void setDeposit(Double deposit) {
        this.deposit = deposit;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }
}
