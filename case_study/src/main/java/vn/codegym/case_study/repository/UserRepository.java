package vn.codegym.case_study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.case_study.model.User;

public interface UserRepository extends JpaRepository<User, String> {
}
