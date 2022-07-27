package vn.codegym.shopping_cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.shopping_cart.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
