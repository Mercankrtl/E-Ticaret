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

    public List<OrderItem> getAllOrderItems() {
        return orderItemRepository.findAll();
    }

    public Optional<OrderItem> getOrderItemById(Long id) {
        return orderItemRepository.findById(id);
    }

    public OrderItem createOrderItem(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }

    public OrderItem updateOrderItem(Long id, OrderItem orderItem) {
        // id'yi field olarak set et
        orderItem.setId(id);
        return orderItemRepository.save(orderItem);
    }

    public void deleteOrderItem(Long id) {
        orderItemRepository.deleteById(id);
    }

    public List<OrderItem> getOrderItemsByOrderId(Long orderId) {
        return orderItemRepository.findByOrder_Id(orderId);
    }

}
