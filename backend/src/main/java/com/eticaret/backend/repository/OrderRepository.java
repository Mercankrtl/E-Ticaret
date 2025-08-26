// src/main/java/com/eticaret/backend/repository/OrderRepository.java
package com.eticaret.backend.repository;

import com.eticaret.backend.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUserUserId(Long userId);
}
