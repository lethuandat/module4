package vn.codegym.product_management.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.product_management.model.Product;

import java.util.Optional;

public interface ProductService {
    Page<Product> findAll(Pageable pageable);

    void save(Product product);

    Optional<Product> findById(int id);

    void remove(int id);

    Page<Product> search(String keyword, Pageable pageInfo);
}
