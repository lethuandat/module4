package vn.codegym.lend_book.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.lend_book.model.Book;
import vn.codegym.lend_book.repository.BookRepository;
import vn.codegym.lend_book.service.BookService;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookRepository bookRepository;
    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }
    @Override
    public Book findById(int id) {
        return bookRepository.findById(id).orElse(null);
    }
}
