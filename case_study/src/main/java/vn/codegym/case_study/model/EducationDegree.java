package vn.codegym.case_study.model;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "education_degree")
public class EducationDegree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int educationDegreeId;
    private String educationDegreeName;

    @OneToMany(mappedBy = "educationDegree")
    private Set<Employee> employee;

    public EducationDegree() {
    }

    public EducationDegree(int educationDegreeId, String educationDegreeName, Set<Employee> employee) {
        this.educationDegreeId = educationDegreeId;
        this.educationDegreeName = educationDegreeName;
        this.employee = employee;
    }

    public int getEducationDegreeId() {
        return educationDegreeId;
    }

    public void setEducationDegreeId(int educationDegreeId) {
        this.educationDegreeId = educationDegreeId;
    }

    public String getEducationDegreeName() {
        return educationDegreeName;
    }

    public void setEducationDegreeName(String educationDegreeName) {
        this.educationDegreeName = educationDegreeName;
    }

    public Set<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(Set<Employee> employee) {
        this.employee = employee;
    }
}
