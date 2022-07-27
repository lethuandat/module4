package vn.codegym.case_study.model;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "facility_type")
public class FacilityType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer facilityTypeId;
    private String facilityTypeName;

    @OneToMany(mappedBy = "facilityType")
    private Set<Facility> facility;

    public FacilityType() {
    }

    public FacilityType(Integer facilityTypeId, String facilityTypeName, Set<Facility> facility) {
        this.facilityTypeId = facilityTypeId;
        this.facilityTypeName = facilityTypeName;
        this.facility = facility;
    }

    public Integer getFacilityTypeId() {
        return facilityTypeId;
    }

    public void setFacilityTypeId(Integer facilityTypeId) {
        this.facilityTypeId = facilityTypeId;
    }

    public String getFacilityTypeName() {
        return facilityTypeName;
    }

    public void setFacilityTypeName(String facilityTypeName) {
        this.facilityTypeName = facilityTypeName;
    }

    public Set<Facility> getFacility() {
        return facility;
    }

    public void setFacility(Set<Facility> facility) {
        this.facility = facility;
    }
}
