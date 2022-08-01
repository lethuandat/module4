package vn.codegym.service;

import vn.codegym.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User findById(Integer id);

    void save(User user);

    void remove(Integer id);

    User findByEmail(String email);
}
