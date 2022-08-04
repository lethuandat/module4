package vn.codegym.case_study.dto;

import vn.codegym.case_study.model.Division;
import vn.codegym.case_study.model.EducationDegree;
import vn.codegym.case_study.model.Position;
import vn.codegym.case_study.model.User;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class EmployeeDto {
    private Integer id;

    @NotBlank(message = "*Không được để trống!")
    @Pattern(message = "*Không đúng định dạng (VD: Lê Văn An)", regexp = "^([A-Z\\p{L}]{1}[a-z\\p{L}]*)+(\\s([A-Z\\p{L}]{1}[a-z\\p{L}]*))*$")
    private String name;


    @NotBlank(message = "*Không được để trống!")
    private String birthDay;


    @NotBlank(message = "*Không được để trống!")
    @Pattern(message = "*Không đúng định dạng (XXXXXXXXX với X là số từ 0 - 9)", regexp = "\\d{9}")
    private String idCard;

    @NotBlank(message = "*Không được để trống!")
    @Pattern(regexp = "[1-9]+\\d*", message = "*Phải nhập số và lớn hơn 0")
    private String salary;

    @NotBlank(message = "*Không được để trống!")
    @Pattern(message = "*Không đúng định dạng (090XXXXXXX hoặc 091XXXXXXX với X là số từ 0 - 9)", regexp = "^090|091\\d{7}$")
    private String phone;

    @NotBlank(message = "*Không được để trống!")
    @Email(message = "*Email không đúng định dạng (abc@example.com ...)", regexp = "^\\w+([.-]?\\w+)*@[a-z]+\\.(\\w+){2,}(\\.\\w{2,3})?")
    private String email;

    @NotBlank(message = "*Không được để trống!")
    private String address;

    @NotBlank(message = "*Không được để trống!")
    private String position;

    @NotBlank(message = "*Không được để trống!")
    private String educationDegree;

    @NotBlank(message = "*Không được để trống!")
    private String division;

    @NotBlank(message = "*Không được để trống!")
    private String username;

    public EmployeeDto() {
    }

    public EmployeeDto(Integer id, String name, String birthDay, String idCard, String salary, String phone, String email, String address, String position, String educationDegree, String division, String username) {
        this.id = id;
        this.name = name;
        this.birthDay = birthDay;
        this.idCard = idCard;
        this.salary = salary;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.position = position;
        this.educationDegree = educationDegree;
        this.division = division;
        this.username = username;
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

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(String educationDegree) {
        this.educationDegree = educationDegree;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
