package vn.codegym.case_study.model;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "rent_type")
public class RentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rentTypeId;
    private String rentTypeName;

    @OneToMany(mappedBy = "rentType")
    private Set<Facility> facility;

    public RentType() {
    }

    public RentType(Integer rentTypeId, String rentTypeName, Set<Facility> facility) {
        this.rentTypeId = rentTypeId;
        this.rentTypeName = rentTypeName;
        this.facility = facility;
    }

    public Integer getRentTypeId() {
        return rentTypeId;
    }

    public void setRentTypeId(Integer rentTypeId) {
        this.rentTypeId = rentTypeId;
    }

    public String getRentTypeName() {
        return rentTypeName;
    }

    public void setRentTypeName(String rentTypeName) {
        this.rentTypeName = rentTypeName;
    }

    public Set<Facility> getFacility() {
        return facility;
    }

    public void setFacility(Set<Facility> facility) {
        this.facility = facility;
    }
}
