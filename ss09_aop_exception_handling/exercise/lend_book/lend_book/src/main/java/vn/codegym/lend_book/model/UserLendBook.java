package vn.codegym.lend_book.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class UserLendBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Long lendCode;

    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book book;

    public UserLendBook() {
    }

    public UserLendBook(Integer id, String name, Long lendCode, Book book) {
        this.id = id;
        this.name = name;
        this.lendCode = lendCode;
        this.book = book;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getLendCode() {
        return lendCode;
    }

    public void setLendCode(Long lendCode) {
        this.lendCode = lendCode;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
