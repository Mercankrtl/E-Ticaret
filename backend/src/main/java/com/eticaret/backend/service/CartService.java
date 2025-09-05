package com.eticaret.backend.service;

import com.eticaret.backend.model.Cart;
import com.eticaret.backend.model.CartItem;
import com.eticaret.backend.model.Product;
import com.eticaret.backend.model.User;
import com.eticaret.backend.repository.CartItemRepository;
import com.eticaret.backend.repository.CartRepository;
import com.eticaret.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private UserRepository userRepository;

    // Kullanıcının sepetini getir veya oluştur
    public Cart getOrCreateCart(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Kullanıcı bulunamadı"));
        Optional<Cart> cartOpt = cartRepository.findByUser(user);
        return cartOpt.orElseGet(() -> {
            Cart newCart = new Cart();
            newCart.setUser(user);
            return cartRepository.save(newCart);
        });
    }

    // Sepete ürün ekle
    @Transactional
    public Cart addToCart(Long userId, Product product, Integer quantity) {
        Cart cart = getOrCreateCart(userId);

        Optional<CartItem> existingItemOpt = cart.getItems().stream()
                .filter(item -> item.getProduct().getId().equals(product.getId()))
                .findFirst();

        if (existingItemOpt.isPresent()) {
            CartItem existingItem = existingItemOpt.get();
            existingItem.setQuantity(existingItem.getQuantity() + quantity);
            cartItemRepository.save(existingItem);
        } else {
            CartItem newItem = new CartItem();
            newItem.setCart(cart);
            newItem.setProduct(product);
            newItem.setQuantity(quantity);
            cart.getItems().add(newItem);
            cartItemRepository.save(newItem);
        }

        return cartRepository.save(cart);
    }

    // Sepetten ürün çıkar
    @Transactional
    public Cart removeFromCart(Long userId, Long productId) {
        Cart cart = getOrCreateCart(userId);
        cart.getItems().removeIf(item -> {
            if (item.getProduct().getId().equals(productId)) {
                cartItemRepository.delete(item);
                return true;
            }
            return false;
        });
        return cartRepository.save(cart);
    }

    // Sepeti temizle
    @Transactional
    public Cart clearCart(Long userId) {
        Cart cart = getOrCreateCart(userId);
        for (CartItem item : cart.getItems()) {
            cartItemRepository.delete(item);
        }
        cart.getItems().clear();
        return cartRepository.save(cart);
    }
}
