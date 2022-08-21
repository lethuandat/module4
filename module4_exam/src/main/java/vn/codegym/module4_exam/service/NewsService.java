package vn.codegym.module4_exam.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.module4_exam.model.News;

import java.util.List;
import java.util.Optional;

public interface NewsService {
    Page<News> findAll(Pageable pageable, String keyword);


    Page<News> findByCategory(Pageable pageable, String keyword);

    List<News> findAll();

    Optional<News> findById(Integer id);

    void save(News news);

    void remove(Integer id);
}
