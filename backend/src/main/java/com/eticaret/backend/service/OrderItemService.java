package com.eticaret.backend.service;

import com.eticaret.backend.model.OrderItem;
import com.eticaret.backend.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;

    // Tüm OrderItem'ları getir
    public List<OrderItem> getAllOrderItems() {
        return orderItemRepository.findAll();
    }

    // ID'ye göre getir
    public Optional<OrderItem> getOrderItemById(Long id) {
        return orderItemRepository.findById(id);
    }

    // Yeni OrderItem ekle
    public OrderItem createOrderItem(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }

    // OrderItem güncelle
    public OrderItem updateOrderItem(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }

    // OrderItem sil
    public void deleteOrderItem(Long id) {
        orderItemRepository.deleteById(id);
    }

    // Belirli bir siparişe ait OrderItem'ları getir
    public List<OrderItem> getOrderItemsByOrderId(Long orderId) {
        return orderItemRepository.findByOrder_OrderId(orderId);
    }
}
