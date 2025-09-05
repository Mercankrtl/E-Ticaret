// src/main/java/com/eticaret/backend/repository/CartItemRepository.java
package com.eticaret.backend.repository;

import com.eticaret.backend.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
}
