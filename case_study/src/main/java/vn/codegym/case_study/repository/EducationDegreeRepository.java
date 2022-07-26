package vn.codegym.case_study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.case_study.model.EducationDegree;

public interface EducationDegreeRepository extends JpaRepository<EducationDegree, Integer> {
}
