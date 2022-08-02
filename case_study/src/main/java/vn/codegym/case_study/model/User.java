package vn.codegym.case_study.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity(name = "user")
public class User {
    @Id
    private String username;
    private String password;
    @OneToOne(mappedBy = "username")
    @JsonBackReference
    private Employee employee;

    public User() {
    }

    public User(String username, String password, Employee employee) {
        this.username = username;
        this.password = password;
        this.employee = employee;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
