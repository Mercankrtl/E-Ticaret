package com.eticaret.backend.service;

import com.eticaret.backend.model.Order;
import com.eticaret.backend.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    // Tüm siparişleri getir
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    // ID'ye göre sipariş getir
    public Optional<Order> getOrderById(Integer id) {
        return orderRepository.findById(id);
    }

    // Yeni sipariş ekle
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    // Sipariş güncelle
    public Order updateOrder(Order order) {
        return orderRepository.save(order);
    }

    // Sipariş sil
    public void deleteOrder(Integer id) {
        orderRepository.deleteById(id);
    }

    // Belirli bir kullanıcıya ait siparişleri getir
    public List<Order> getOrdersByUserId(Long userId) {
        return orderRepository.findByUserUserId(userId);
    }
}
