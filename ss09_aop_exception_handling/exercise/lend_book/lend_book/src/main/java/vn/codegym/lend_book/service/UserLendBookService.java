package vn.codegym.lend_book.service;

import vn.codegym.lend_book.model.UserLendBook;

import java.util.List;

public interface UserLendBookService {
    List<UserLendBook> findAll();
    void save(UserLendBook userLendBook);
    UserLendBook findById(int id);

    UserLendBook findByLendCode(Long code);

    void remove(UserLendBook userLendBook);
}
