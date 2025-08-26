// src/main/java/com/eticaret/backend/model/ProductTagId.java
package com.eticaret.backend.model;

import java.io.Serializable;
import java.util.Objects;

public class ProductTagId implements Serializable {

    private Long product; // maps to Product.id
    private Long tag;     // maps to Tag.tagId

    public ProductTagId() {}
    public ProductTagId(Long product, Long tag) {
        this.product = product;
        this.tag = tag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductTagId)) return false;
        ProductTagId that = (ProductTagId) o;
        return Objects.equals(product, that.product) && Objects.equals(tag, that.tag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, tag);
    }
}
