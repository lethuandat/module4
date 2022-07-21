package vn.codegym.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.codegym.blog.model.Blog;

import javax.transaction.Transactional;

@Transactional
public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    @Modifying
    @Query(value = "update Blog set content = :content,  name = :name, status = :status, topic = :topic where id = :id", nativeQuery = true)
    void update(@Param("content") String content, @Param("name") String name, @Param("status") String status, @Param("topic") String topic, @Param("id") Integer id);

}
