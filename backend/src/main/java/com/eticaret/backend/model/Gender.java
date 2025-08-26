// src/main/java/com/eticaret/backend/model/Gender.java
package com.eticaret.backend.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "genders")
public class Gender {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long genderId;

    @Column(unique = true, nullable = false)
    private String name;

    @OneToMany(mappedBy = "gender", cascade = CascadeType.ALL)
    private List<Product> products;

    public Gender() {}
    public Gender(String name) { this.name = name; }

    public Long getGenderId() { return genderId; }
    public void setGenderId(Long genderId) { this.genderId = genderId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public List<Product> getProducts() { return products; }
    public void setProducts(List<Product> products) { this.products = products; }
}
