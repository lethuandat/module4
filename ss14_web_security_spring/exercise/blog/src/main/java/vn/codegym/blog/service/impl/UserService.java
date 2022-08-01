package vn.codegym.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.blog.model.User;
import vn.codegym.blog.repository.IUserRepository;
import vn.codegym.blog.service.IUserService;

@Service
public class UserService implements IUserService {
    @Autowired
    IUserRepository iUserRepository;

    @Override
    public User findByUsername(String username) {
        return iUserRepository.findByUsername(username);
    }
}
