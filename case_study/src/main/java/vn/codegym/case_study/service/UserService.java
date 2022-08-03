package vn.codegym.case_study.service;

import vn.codegym.case_study.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User findByUsername(String username);
}
