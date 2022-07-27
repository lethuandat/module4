package vn.codegym.shopping_cart.service;

import vn.codegym.shopping_cart.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> findAll();

    void save(Product product);

    Optional<Product> findById(Long id);
}
