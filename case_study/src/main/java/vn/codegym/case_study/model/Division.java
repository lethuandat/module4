package vn.codegym.case_study.model;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "division")
public class Division {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int divisionId;
    private String divisionName;

    @OneToMany(mappedBy = "divisionId")
    private Set<Employee> employee;

    public Division() {
    }

    public Division(int divisionId, String divisionName, Set<Employee> employee) {
        this.divisionId = divisionId;
        this.divisionName = divisionName;
        this.employee = employee;
    }

    public int getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(int divisionId) {
        this.divisionId = divisionId;
    }

    public String getDivisionName() {
        return divisionName;
    }

    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
    }

    public Set<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(Set<Employee> employee) {
        this.employee = employee;
    }
}
