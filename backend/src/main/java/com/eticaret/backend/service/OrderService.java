// src/main/java/com/eticaret/backend/service/OrderService.java
package com.eticaret.backend.service;

import com.eticaret.backend.dto.CartItemDTO;
import com.eticaret.backend.model.Order;
import com.eticaret.backend.model.OrderItem;
import com.eticaret.backend.model.Product;
import com.eticaret.backend.model.User;
import com.eticaret.backend.repository.OrderRepository;
import com.eticaret.backend.repository.ProductRepository;
import com.eticaret.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    public List<Order> getOrdersByUserId(Long userId) {
        return orderRepository.findByUserUserId(userId);
    }

    @Transactional
    public Order createOrder(Long userId, List<CartItemDTO> cartItems) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Kullanıcı bulunamadı"));

        Order order = new Order();
        order.setUser(user);
        order.setCreatedAt(LocalDateTime.now());

        List<OrderItem> items = new ArrayList<>();
        double totalAmount = 0.0;

        for (CartItemDTO cartItem : cartItems) {
            Product product = productRepository.findById(cartItem.getProductId())
                    .orElseThrow(() -> new RuntimeException("Ürün bulunamadı: " + cartItem.getProductId()));

            if (product.getStock() < cartItem.getQuantity()) {
                throw new RuntimeException("Yeterli stok yok: " + product.getName());
            }

            // Stok güncelle
            product.setStock(product.getStock() - cartItem.getQuantity());
            productRepository.save(product);

            OrderItem orderItem = new OrderItem();
            orderItem.setProduct(product);
            orderItem.setQuantity(cartItem.getQuantity());
            orderItem.setPrice(product.getPrice().doubleValue()); // BigDecimal → Double
            orderItem.setOrder(order);

            items.add(orderItem);

            // toplam fiyatı ekle
            totalAmount += orderItem.getPrice() * orderItem.getQuantity();
        }

        order.setItems(items);
        order.setTotalAmount(totalAmount);

        return orderRepository.save(order);
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

    public Order updateOrder(Order order) {
        return orderRepository.save(order);
    }
}
