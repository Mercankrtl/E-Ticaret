// src/main/java/com/eticaret/backend/model/Tag.java
package com.eticaret.backend.model;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "tags")
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tagId;

    @Column(unique = true, nullable = false)
    private String name;

    @OneToMany(mappedBy = "tag")
    private Set<ProductTag> productTags;

    public Tag() {}
    public Tag(String name) { this.name = name; }

    public Long getTagId() { return tagId; }
    public void setTagId(Long tagId) { this.tagId = tagId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Set<ProductTag> getProductTags() { return productTags; }
    public void setProductTags(Set<ProductTag> productTags) { this.productTags = productTags; }
}
