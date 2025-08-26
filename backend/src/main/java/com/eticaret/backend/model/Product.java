package com.eticaret.backend.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double price;
    private int stock;
    private String description;

    // Category ile ilişki
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    // Gender ile ilişki
    @ManyToOne
    @JoinColumn(name = "gender_id")
    private Gender gender;
}
