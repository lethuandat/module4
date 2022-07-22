package vn.codegym.product_management.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.product_management.model.Product;
import vn.codegym.product_management.repository.ProductRepository;
import vn.codegym.product_management.service.ProductService;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public Optional<Product> findById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public void remove(int id) {
        productRepository.deleteById(id);
    }

    @Override
    public Page<Product> search(String keyword, Pageable pageInfo) {
        return productRepository.findAllByNameContainsOrProduceContains(keyword, keyword, pageInfo);
    }
}
