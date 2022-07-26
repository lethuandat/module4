package vn.codegym.lend_book.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String author;
    private Integer quantity;

    @OneToMany(mappedBy = "book")
    private Set<UserLendBook> userLendBook;

    public Book() {
    }

    public Book(Integer id, String name, String author, Integer quantity, Set<UserLendBook> userLendBook) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.quantity = quantity;
        this.userLendBook = userLendBook;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Set<UserLendBook> getUserLendBook() {
        return userLendBook;
    }

    public void setUserLendBook(Set<UserLendBook> userLendBook) {
        this.userLendBook = userLendBook;
    }
}
