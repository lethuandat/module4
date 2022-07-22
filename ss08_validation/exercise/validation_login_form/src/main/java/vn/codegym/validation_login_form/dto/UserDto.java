package vn.codegym.validation_login_form.dto;

import javax.validation.constraints.*;

public class UserDto {
    private Integer id;

    @NotBlank(message = "First name is not empty!")
    @Size(min = 5, max = 45)
    private String firstName;

    @NotBlank(message = "Last name is not empty!")
    @Size(min = 5, max = 45)
    private String lastName;

    @NotBlank(message = "Phone is not empty!")
    @Pattern(regexp = "^090\\d{7}$")
    private String phone;

    @NotNull
    @Min(18)
    private Integer age;

    @NotBlank(message = "Email is not empty!")
    @Email(message = "Email is not valid", regexp = "^\\w+([.-]?\\w+)*@[a-z]+\\.(\\w+){2,}(\\.\\w{2,3})?")
    private String email;

    public UserDto() {
    }

    public UserDto(Integer id, @NotBlank(message = "First name is not empty!") @Size(min = 5, max = 45) String firstName, @NotBlank(message = "Last name is not empty!") @Size(min = 5, max = 45) String lastName, @NotBlank(message = "Phone is not empty!") @Pattern(regexp = "^0\\d{9}$") String phone, @NotNull @Min(18) Integer age, @NotBlank(message = "Email is not empty!") @Email(message = "Email is not valid", regexp = "^\\w+([.-]?\\w+)*@[a-z]+\\.(\\w+){2,}(\\.\\w{2,3})?") String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.age = age;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
