package com.codegym.model;

public class Product {
    private Integer id;
    private String name;
    private String produce;
    private Integer quantity;
    private Double price;

    public Product() {
    }

    public Product(Integer id, String name, String produce, Integer quantity, Double price) {
        this.id = id;
        this.name = name;
        this.produce = produce;
        this.quantity = quantity;
        this.price = price;
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

    public String getProduce() {
        return produce;
    }

    public void setProduce(String produce) {
        this.produce = produce;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
