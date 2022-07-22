package vn.codegym.validation_login_form.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.validation_login_form.model.User;

public interface IUserRepository extends JpaRepository<User, Integer> {
}
