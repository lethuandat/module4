package vn.codegym.service;

import vn.codegym.model.Role;

import java.util.List;

public interface RoleService {

    List<Role> findAll();

    Role findById(Integer id);

    void save(Role role);

    void remove(Integer id);


    Role findByName(String name);
}
