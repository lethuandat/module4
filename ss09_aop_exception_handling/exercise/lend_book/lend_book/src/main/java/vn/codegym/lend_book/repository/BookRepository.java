package vn.codegym.lend_book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.lend_book.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
