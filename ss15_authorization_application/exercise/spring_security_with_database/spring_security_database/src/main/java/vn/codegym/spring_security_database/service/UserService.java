package vn.codegym.spring_security_database.service;

import vn.codegym.spring_security_database.model.User;

public interface UserService {
    User findByUsername(String username);
}
