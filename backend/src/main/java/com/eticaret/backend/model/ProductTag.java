package com.eticaret.backend.model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "product_tags")
@IdClass(ProductTagId.class)
public class ProductTag {

    @Id
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Id
    @ManyToOne
    @JoinColumn(name = "tag_id", nullable = false)
    private Tag tag;

    // Constructors
    public ProductTag() {}

    public ProductTag(Product product, Tag tag) {
        this.product = product;
        this.tag = tag;
    }

    // Getters & Setters
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }
}
