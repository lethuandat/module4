package vn.codegym.blog.service;

import vn.codegym.blog.model.User;

public interface IUserService {
    User findByUsername(String username);
}
