package vn.codegym.product_management.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import vn.codegym.product_management.model.Product;

import java.util.List;

@Transactional
public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Modifying
    @Query(value = "select * from Product where name like :name", nativeQuery = true)
    List<Product> findByNameOrProduce(@Param("name") String keyword);

    Page<Product> findAll(Pageable pageable);
}
