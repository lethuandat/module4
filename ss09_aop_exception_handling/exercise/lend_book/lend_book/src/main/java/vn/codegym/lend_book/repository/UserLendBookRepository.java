package vn.codegym.lend_book.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.lend_book.model.UserLendBook;

public interface UserLendBookRepository extends JpaRepository<UserLendBook, Integer> {
    UserLendBook findByLendCode(Long code);
}
