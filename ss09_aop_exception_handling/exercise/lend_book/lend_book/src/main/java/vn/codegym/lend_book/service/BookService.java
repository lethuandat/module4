package vn.codegym.lend_book.service;

import vn.codegym.lend_book.model.Book;

import java.util.List;

public interface BookService {
    List<Book> findAll();

    void save(Book book);
    Book findById(int id);
}
