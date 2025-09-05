package com.eticaret.backend.repository;

import com.eticaret.backend.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    // Order entity'sindeki 'id' alanını kullanıyoruz
    List<OrderItem> findByOrder_Id(Long orderId);
}
