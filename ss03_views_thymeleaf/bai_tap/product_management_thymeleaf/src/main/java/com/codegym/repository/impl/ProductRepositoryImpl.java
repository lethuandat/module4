package com.codegym.repository.impl;

import com.codegym.model.Product;
import com.codegym.repository.ProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
    private static final Map<Integer, Product> products;

    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "Insprion 15", "Dell", 14, 799.9));
        products.put(2, new Product(2, "Zenbook 13", "Asus", 4, 499.9));
        products.put(3, new Product(3, "XPS 15", "Dell", 5, 1199.9));
        products.put(4, new Product(4, "Pavilion 14", "HP", 4, 649.9));
        products.put(5, new Product(5, "Predator X", "Acer", 4, 1499.9));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        int max = 0;
        for (Product item : findAll()) {
            if (item.getId() > max) {
                max = item.getId();
            }
        }
        product.setId(max + 1);
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }

    @Override
    public List<Product> search(String keyword) {
        List<Product> searchList = new ArrayList<>();
        for (Product item : products.values()) {
            if (item.getName().contains(keyword) || item.getProduce().contains(keyword)) {
                searchList.add(item);
            }
        }
        return searchList;
    }
}
