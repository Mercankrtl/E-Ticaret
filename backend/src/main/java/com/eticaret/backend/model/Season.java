package com.eticaret.backend.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.ArrayList;

@Data
@Entity
@Table(name = "seasons")
public class Season {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name; // Örn: "spring", "summer", "autumn", "winter"

    @OneToMany(mappedBy = "season")
    private List<Product> products = new ArrayList<>();
}
