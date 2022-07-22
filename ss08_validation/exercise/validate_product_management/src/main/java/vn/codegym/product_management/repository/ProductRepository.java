package vn.codegym.product_management.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import vn.codegym.product_management.model.Product;

@Transactional
public interface ProductRepository extends JpaRepository<Product, Integer> {
    Page<Product> findAllByNameContainsOrProduceContains(String name, String produce, Pageable pageInfo);
}
