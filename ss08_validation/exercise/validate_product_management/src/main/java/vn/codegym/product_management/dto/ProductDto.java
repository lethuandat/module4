package vn.codegym.product_management.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ProductDto {
    private Integer id;

    @NotBlank(message = "Name product is not empty!")
    @Size(min = 5, max = 45)
    private String name;

    @NotBlank(message = "Produce is not empty!")
    @Size(min = 5, max = 45)
    private String produce;

    @NotNull
    @Min(1)
    private Integer quantity;

    @NotNull
    @Min(1)
    private Double price;

    public ProductDto() {
    }

    public ProductDto(Integer id, @NotBlank(message = "Name product is not empty!") @Size(min = 5, max = 45) String name, @NotBlank(message = "Name product is not empty!") @Size(min = 5, max = 45) String produce, @NotNull @Min(1) Integer quantity, @NotNull @Min(1) Double price) {
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
