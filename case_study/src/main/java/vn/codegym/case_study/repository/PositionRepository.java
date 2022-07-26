package vn.codegym.case_study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.case_study.model.Position;

public interface PositionRepository extends JpaRepository<Position, Integer> {
}
