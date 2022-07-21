package vn.codegym.blog.service;

import vn.codegym.blog.model.Category;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {
    List<Category> findAll();

    Optional<Category> findById(Integer id);

    void save(Category category);

    void remove(Integer id);
}
