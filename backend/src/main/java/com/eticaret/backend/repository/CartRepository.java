// src/main/java/com/eticaret/backend/repository/CartRepository.java
package com.eticaret.backend.repository;

import com.eticaret.backend.model.Cart;
import com.eticaret.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Long> {
    Optional<Cart> findByUser(User user);
}
