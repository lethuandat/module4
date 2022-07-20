package vn.codegym.blog.service;

import vn.codegym.blog.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    Blog findById(Integer id);

    void save(Blog blog);

    void update(Blog blog);

    void remove(Integer id);
}
