package vn.codegym.module4_exam.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.module4_exam.model.News;
import vn.codegym.module4_exam.repository.NewsRepository;
import vn.codegym.module4_exam.service.NewsService;

import java.util.List;
import java.util.Optional;

@Service

public class NewsServiceImpl implements NewsService {
    @Autowired
    NewsRepository newsRepository;

    @Override
    public Page<News> findAll(Pageable pageable, String keyword) {
        return newsRepository.findAll(pageable, "%" + keyword + "%");
    }

    @Override
    public Page<News> findByCategory(Pageable pageable, String keyword) {
        return newsRepository.findByCategory(pageable, keyword);
    }

    @Override
    public List<News> findAll() {
        return newsRepository.findAll();
    }

    @Override
    public Optional<News> findById(Integer id) {
        return newsRepository.findById(id);
    }

    @Override
    public void save(News news) {
        newsRepository.save(news);
    }

    @Override
    public void remove(Integer id) {
        newsRepository.deleteById(id);
    }
}
