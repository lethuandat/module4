package vn.codegym.case_study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.case_study.model.FacilityType;

public interface FacilityTypeRepository extends JpaRepository<FacilityType, Integer> {
}
