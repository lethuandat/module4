package vn.codegym.case_study.dto;


import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import vn.codegym.case_study.model.Customer;
import vn.codegym.case_study.repository.CustomerRepository;
import vn.codegym.case_study.service.CustomerService;
import vn.codegym.case_study.service.impl.CustomerServiceImpl;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class CustomerDto implements Validator {
    private Integer id;

    @NotBlank(message = "*Không được để trống!")
    private String customerType;

    @NotBlank(message = "*Không được để trống!")
    @Pattern(message = "*Không đúng định dạng (VD: Lê Văn An)", regexp = "^([A-Z\\p{L}]{1}[a-z\\p{L}]*)+(\\s([A-Z\\p{L}]{1}[a-z\\p{L}]*))*$")
    private String name;

    @NotBlank(message = "*Không được để trống!")
    private String birthDay;

    @NotBlank(message = "*Không được để trống!")
    private String gender;

    @NotBlank(message = "*Không được để trống!")
    @Pattern(message = "*Không đúng định dạng (XXXXXXXXX với X là số từ 0 - 9)", regexp = "\\d{9}")
    private String idCard;

    @NotBlank(message = "*Không được để trống!")
    @Pattern(message = "*Không đúng định dạng (090XXXXXXX hoặc 091XXXXXXX hoặc (84)+90XXXXXXX hoặc (84)+91XXXXXXX, với X là số từ 0 - 9)", regexp = "^(090|091|(84)\\+90|(84)\\+91)\\d{7}$")
    private String phone;

    @NotBlank(message = "*Không được để trống!")
    @Email(message = "*Email không đúng định dạng (abc@example.com ...)", regexp = "^\\w+([.-]?\\w+)*@[a-z]+\\.(\\w+){2,}(\\.\\w{2,3})?")
    private String email;

    @NotBlank(message = "*Không được để trống!")
    private String address;

    public CustomerDto() {
    }

    public CustomerDto(Integer id, String customerType, String name, String birthDay, String gender, String idCard, String phone, String email, String address) {
        this.id = id;
        this.customerType = customerType;
        this.name = name;
        this.birthDay = birthDay;
        this.gender = gender;
        this.idCard = idCard;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    public void validate(Object target, Errors errors) {
        CustomerDto customerDto = (CustomerDto) target;
//        List<Customer> customerList = customerService.getList();

        if (Period.between(LocalDate.parse(customerDto.getBirthDay(), formatter), LocalDate.now()).getDays() < 6570) {
            errors.rejectValue("birthDay", "birthday.fail", "*Ngày nhập lỗi");
        }

//        for (Customer item : customerList) {
//            if (item.getEmail().equals(customerDto.getEmail())) {
//                errors.rejectValue("email", "email.existed", "*Email đã tồn tại.");
//            }
//
//            if (item.getIdCard().equals(customerDto.getIdCard())) {
//                errors.rejectValue("idCard", "idCard.existed", "*Số CMND đã tồn tại.");
//            }
//
//            if (item.getPhone().equals(customerDto.getPhone())) {
//                errors.rejectValue("phone", "phone.existed", "*Số điện thoại đã tồn tại.");
//            }
//        }

    }
}
