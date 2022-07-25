package vn.codegym.case_study.model;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "position")
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int positionId;
    private String positionName;

    @OneToMany(mappedBy = "positionId")
    private Set<Employee> employee;

    public Position() {
    }

    public Position(int positionId, String positionName, Set<Employee> employee) {
        this.positionId = positionId;
        this.positionName = positionName;
        this.employee = employee;
    }

    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public Set<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(Set<Employee> employee) {
        this.employee = employee;
    }
}
