package com.cloud.yagodev.dscommerce.domain.dtos;

import com.cloud.yagodev.dscommerce.domain.entities.Product;

import java.math.BigDecimal;

public class ProductDTO {
    private Long id;
    private String name;
    private String description;
    private String imgUrl;
    private BigDecimal price;

    public ProductDTO() {
    }

    public ProductDTO(Long id, String name, String description, String imgUrl, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imgUrl = imgUrl;
        this.price = price;
    }

    public ProductDTO(Product product) {
        id = product.getId();
        name = product.getName();
        description = product.getDescription();
        imgUrl = product.getImgUrl();
        price = product.getPrice();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
