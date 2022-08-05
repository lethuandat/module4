package vn.codegym.case_study.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity(name = "user")
public class User {
    @Id
    private String username;
    private String password;

    private boolean isEnable;
    @OneToOne(mappedBy = "username")
    @JsonBackReference
    private Employee employee;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "username"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> role;
    public User() {
    }

    public User(String username) {
        this.username = username;
    }

    public User(String username, String password, boolean isEnable, Employee employee, List<Role> role) {
        this.username = username;
        this.password = password;
        this.isEnable = isEnable;
        this.employee = employee;
        this.role = role;
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

    public boolean isEnable() {
        return isEnable;
    }

    public void setEnable(boolean enable) {
        isEnable = enable;
    }

    public List<Role> getRole() {
        return role;
    }

    public void setRole(List<Role> role) {
        this.role = role;
    }
}
