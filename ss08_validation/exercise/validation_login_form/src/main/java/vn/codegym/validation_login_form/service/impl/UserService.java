package vn.codegym.validation_login_form.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.validation_login_form.model.User;
import vn.codegym.validation_login_form.repository.IUserRepository;
import vn.codegym.validation_login_form.service.IUserService;

import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    IUserRepository iUserRepository;


    @Override
    public List<User> findAll() {
        return iUserRepository.findAll();
    }

    @Override
    public void save(User user) {
        iUserRepository.save(user);
    }
}
