package vn.codegym.blog.service;

import vn.codegym.blog.model.Blog;

import java.util.List;
import java.util.Optional;

public interface IBlogService {
    List<Blog> findAll();

    Optional<Blog> findById(Integer id);

    void save(Blog blog);

    void remove(Integer id);

    List<Blog> findAllByCategoryId(Integer id);
}
