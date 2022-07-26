package vn.codegym.lend_book.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.lend_book.model.UserLendBook;
import vn.codegym.lend_book.repository.UserLendBookRepository;
import vn.codegym.lend_book.service.UserLendBookService;

import java.util.List;

@Service
public class UserLendBookServiceImpl implements UserLendBookService {
    @Autowired
    UserLendBookRepository userLendBookRepository;

    @Override
    public List<UserLendBook> findAll() {
        return userLendBookRepository.findAll();
    }

    @Override
    public void save(UserLendBook userLendBook) {
        long code = (long) Math.floor(Math.random() * 89999) + 10000;
        userLendBook.setLendCode(code);
        userLendBookRepository.save(userLendBook);
    }

    @Override
    public UserLendBook findById(int id) {
        return userLendBookRepository.findById(id).orElse(null);
    }

    @Override
    public UserLendBook findByLendCode(Long code) {
        return userLendBookRepository.findByLendCode(code);
    }

    @Override
    public void remove(UserLendBook userLendBook) {
        userLendBookRepository.delete(userLendBook);
    }
}
