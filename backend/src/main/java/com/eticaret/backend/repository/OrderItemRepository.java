// src/main/java/com/eticaret/backend/repository/OrderItemRepository.java
package com.eticaret.backend.repository;

import com.eticaret.backend.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    List<OrderItem> findByOrder_OrderId(Long orderId);
}
