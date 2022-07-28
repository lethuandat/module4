package vn.codegym.case_study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.case_study.model.RentType;

public interface RentTypeRepository extends JpaRepository<RentType, Integer> {
}
