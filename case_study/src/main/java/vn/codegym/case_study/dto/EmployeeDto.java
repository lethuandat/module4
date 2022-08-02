package vn.codegym.case_study.dto;

import vn.codegym.case_study.model.Division;
import vn.codegym.case_study.model.EducationDegree;
import vn.codegym.case_study.model.Position;
import vn.codegym.case_study.model.User;

import javax.validation.constraints.*;

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

    @NotEmpty(message = "*Không được để trống!")
    @Min(value = 1, message = "*Phải nhập số > 0")
    private Double salary;


    @NotBlank(message = "*Không được để trống!")
    @Pattern(message = "*Không đúng định dạng (090XXXXXXX hoặc 091XXXXXXX với X là số từ 0 - 9)",regexp = "^090|091\\d{7}$")
    private String phone;

    @NotBlank(message = "*Không được để trống!")
    @Email(message = "*Email không đúng định dạng (abc@example.com ...)", regexp = "^\\w+([.-]?\\w+)*@[a-z]+\\.(\\w+){2,}(\\.\\w{2,3})?")
    private String email;

    @NotBlank(message = "*Không được để trống!")
    private String address;

    @NotNull(message = "*Không được để trống!")
    private Position position;

    @NotNull(message = "*Không được để trống!")
    private EducationDegree educationDegree;

    @NotNull(message = "*Không được để trống!")
    private Division division;

    @NotNull(message = "*Không được để trống!")
    private User username;

    public EmployeeDto() {
    }

    public EmployeeDto(Integer id, String name, String birthDay, String idCard, Double salary, String phone, String email, String address, Position position, EducationDegree educationDegree, Division division, User username) {
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

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
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

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public User getUsername() {
        return username;
    }

    public void setUsername(User username) {
        this.username = username;
    }
}
