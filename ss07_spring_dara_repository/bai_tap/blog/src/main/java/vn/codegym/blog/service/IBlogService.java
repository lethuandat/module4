package vn.codegym.blog.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.blog.model.Blog;

import java.util.Optional;

public interface IBlogService {
    Page<Blog> findAll(Pageable pageable);

    Optional<Blog> findById(Integer id);

    void save(Blog blog);

    void remove(Integer id);
}
