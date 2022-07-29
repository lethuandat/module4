package vn.codegym.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.codegym.blog.model.Blog;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    @Query(value = "select * from blog where category_id = :category_id", nativeQuery = true)
    List<Blog> findAllByCategoryId(@Param("category_id") Integer id);

    @Query(value = "insert into blog (name, category_id, content, status) values(:name, :category_id, :content, :status)", nativeQuery = true)
    void addBlog(@Param("name") String name, @Param("category_id") Integer categoryId, @Param("content") String content, @Param("status") String status);

    List<Blog> findAllByNameContains(String keyword);
}
