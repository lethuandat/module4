package vn.codegym.blog.dto;

import vn.codegym.blog.model.Category;

import java.util.Date;

public class BlogDto {
    private Integer id;
    private String name;
    private Category category;
    private String content;
    private String status;
    private Date dateCreate;

    public BlogDto() {
    }

    public BlogDto(Integer id, String name, Category category, String content, String status, Date dateCreate) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.content = content;
        this.status = status;
        this.dateCreate = dateCreate;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }
}
