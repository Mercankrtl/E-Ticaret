// src/main/java/com/eticaret/backend/controller/OrderController.java
package com.eticaret.backend.controller;

import com.eticaret.backend.dto.CartItemDTO;
import com.eticaret.backend.model.Order;
import com.eticaret.backend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
        Optional<Order> order = orderService.getOrderById(id);
        return order.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Sepet → Sipariş oluşturma
    @PostMapping("/create/{userId}")
    public ResponseEntity<?> createOrder(
            @PathVariable Long userId,
            @RequestBody List<CartItemDTO> cartItems) {
        try {
            Order order = orderService.createOrder(userId, cartItems);
            return ResponseEntity.ok(order); // içinde totalAmount da var
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Order> updateOrder(
            @PathVariable Long id,
            @RequestBody Order orderDetails) {
        Optional<Order> existingOrder = orderService.getOrderById(id);
        if (existingOrder.isPresent()) {
            Order order = existingOrder.get();
            order.setStatus(orderDetails.getStatus());
            order.setTotalAmount(orderDetails.getTotalAmount());
            Order updatedOrder = orderService.updateOrder(order);
            return ResponseEntity.ok(updatedOrder);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }
}
