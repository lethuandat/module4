package vn.codegym.case_study.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.codegym.case_study.model.Facility;

public interface FacilityRepository extends JpaRepository<Facility, Integer> {
    @Query(value = "select * from facility where name like :keyword or other_description like :keyword or facility_free like :keyword", nativeQuery = true,
    countQuery = "select  count(*) from(select * from facility where name like :keyword or other_description like :keyword or facility_free like :keyword) temp_table")
    Page<Facility> findAll(Pageable pageable, @Param("keyword") String keyword);
}
