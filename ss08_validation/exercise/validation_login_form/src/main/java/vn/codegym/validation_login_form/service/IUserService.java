package vn.codegym.validation_login_form.service;

import vn.codegym.validation_login_form.model.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();

    void save(User user);
}
