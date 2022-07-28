package vn.codegym.case_study.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.case_study.model.Facility;

public interface FacilityRepository extends JpaRepository<Facility, Integer> {
    Page<Facility> findAllByNameContainsOrAreaContainsOrCostContains(String name, String area, String cost, Pageable pageable);
}
