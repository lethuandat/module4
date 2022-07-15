package com.codegym.service;

import com.codegym.model.Login;
import com.codegym.model.User;
import com.codegym.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;

    @Override
    public User checkLogin(Login login) {
        return userRepository.checkLogin(login);
    }
}
