package vn.codegym.case_study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.case_study.model.Division;

public interface DivisionRepository extends JpaRepository<Division, Integer> {
}
