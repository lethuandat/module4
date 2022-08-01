package vn.codegym.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.blog.model.User;

public interface IUserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
