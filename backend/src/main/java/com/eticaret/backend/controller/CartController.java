package com.eticaret.backend.controller;

import com.eticaret.backend.model.Cart;
import com.eticaret.backend.model.Product;
import com.eticaret.backend.service.CartService;
import com.eticaret.backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/carts")
@CrossOrigin(origins = "http://localhost:3000") // frontend CORS engelini kaldırır
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private ProductRepository productRepository;

    // Kullanıcının sepetini getir
    @GetMapping("/{userId}")
    public ResponseEntity<Cart> getCart(@PathVariable Long userId) {
        Cart cart = cartService.getOrCreateCart(userId);
        return ResponseEntity.ok(cart);
    }

    // Sepete ürün ekle
    @PostMapping("/{userId}/add")
    public ResponseEntity<Cart> addToCart(
            @PathVariable Long userId,
            @RequestParam Long productId,
            @RequestParam(required = false, defaultValue = "1") Integer quantity
    ) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Ürün bulunamadı"));
        Cart cart = cartService.addToCart(userId, product, quantity);
        return ResponseEntity.ok(cart);
    }

    // Sepetten ürün çıkar
    @DeleteMapping("/{userId}/remove/{productId}")
    public ResponseEntity<Cart> removeFromCart(
            @PathVariable Long userId,
            @PathVariable Long productId
    ) {
        Cart cart = cartService.removeFromCart(userId, productId);
        return ResponseEntity.ok(cart);
    }

    // Sepeti temizle
    @DeleteMapping("/{userId}/clear")
    public ResponseEntity<Cart> clearCart(@PathVariable Long userId) {
        Cart cart = cartService.clearCart(userId);
        return ResponseEntity.ok(cart);
    }
}
