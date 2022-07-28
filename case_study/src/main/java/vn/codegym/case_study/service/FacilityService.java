package vn.codegym.case_study.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.case_study.model.Facility;

import java.util.Optional;

public interface FacilityService {
    Page<Facility> findAll(Pageable pageable);

    Optional<Facility> findById(Integer id);

    void save(Facility facility);

    void remove(Integer id);

    Page<Facility> search(String keyword, Pageable pageable);
}
