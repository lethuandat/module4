package com.codegym.repository.impl;

import com.codegym.model.Product;
import com.codegym.repository.ConnectionUtil;
import com.codegym.repository.ProductRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class ProductRepositoryImpl implements ProductRepository {
    Session session = null;
    List<Product> productList;

    @Override
    public List<Product> findAll() {
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            productList = session.createQuery("from Product").getResultList();
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return productList;
    }


    @Override
    public void save(Product product) {
        Transaction transaction = null;
        try {

            session = ConnectionUtil.sessionFactory.openSession();

            transaction = session.beginTransaction();

            session.save(product);

            transaction.commit();

        } catch (Exception e) {

            if (transaction != null) {

                transaction.rollback();

            }
        } finally {

            if (session != null) {

                session.close();

            }
        }
    }

    @Override
    public Product findById(int id) {
        Product product = null;

        Transaction transaction = null;
        try {

            session = ConnectionUtil.sessionFactory.openSession();

            transaction = session.beginTransaction();

            product = session.get(Product.class, id);

            transaction.commit();

        } catch (Exception e) {

            if (transaction != null) {

                transaction.rollback();

            }
        } finally {

            if (session != null) {

                session.close();

            }
        }

        return product;
    }

    @Override
    public void update(int id, Product product) {
        Transaction transaction = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            productList = session.createQuery("from Product ").getResultList();
            transaction = session.beginTransaction();

            for (Product item : productList) {
                if (item.getId().equals(id)) {
                    item.setName(product.getName());
                    item.setProduce(product.getProduce());
                    item.setQuantity(product.getQuantity());
                    item.setPrice(product.getPrice());
                }
            }

            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void remove(int id) {
        Transaction transaction = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            productList = session.createQuery("from Product ").getResultList();
            transaction = session.beginTransaction();

            for (Product item : productList) {
                if (item.getId().equals(id)) {
                    session.remove(item);
                }
            }

            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Product> search(String keyword) {
        Transaction transaction = null;
        List<Product> productListBySearching = new ArrayList<>();
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            productList = session.createQuery("from Product ").getResultList();
            transaction = session.beginTransaction();

            for (Product item : productList) {
                if (item.getName().contains(keyword) || item.getProduce().contains(keyword)) {
                    productListBySearching.add(item);
                }
            }

            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return productListBySearching;
    }
}
