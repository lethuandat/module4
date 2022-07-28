package vn.codegym.blog.service;

import vn.codegym.blog.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();

    Category findById(Integer id);

    void save(Category category);

    void remove(Integer id);
}
