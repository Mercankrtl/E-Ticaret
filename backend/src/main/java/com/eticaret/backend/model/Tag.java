package com.eticaret.backend.model;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "tags")
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tagId;

    @Column(unique = true, nullable = false)
    private String name;

    // Eğer istersen ProductTag ile ilişki ekleyebilirsin
    @OneToMany(mappedBy = "tag")
    private Set<ProductTag> productTags;

    // Constructors
    public Tag() {
    }

    public Tag(String name) {
        this.name = name;
    }

    // Getters & Setters
    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<ProductTag> getProductTags() {
        return productTags;
    }

    public void setProductTags(Set<ProductTag> productTags) {
        this.productTags = productTags;
    }
}
