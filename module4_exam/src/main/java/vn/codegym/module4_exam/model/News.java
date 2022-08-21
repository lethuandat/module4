package vn.codegym.module4_exam.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity

public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String content;
    private LocalDate date;
    private String interPreview;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    public News() {
    }

    public News(Integer id, String name, String content, LocalDate date, String interPreview, Category category) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.date = date;
        this.interPreview = interPreview;
        this.category = category;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getInterPreview() {
        return interPreview;
    }

    public void setInterPreview(String interPreview) {
        this.interPreview = interPreview;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
