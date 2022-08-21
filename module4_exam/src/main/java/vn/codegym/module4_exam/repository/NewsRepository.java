package vn.codegym.module4_exam.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import vn.codegym.module4_exam.model.News;


@Transactional
public interface NewsRepository extends JpaRepository<News, Integer> {
    @Query(value = "select * from news where name like :keyword", nativeQuery = true)
    Page<News> findAll(Pageable pageable, @Param("keyword") String keyword);

    @Query(value = "select * from news where category_id =:category", nativeQuery = true)
    Page<News> findByCategory(Pageable pageable, @Param("category") String keyword);

}
