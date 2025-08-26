package com.eticaret.backend.repository;

import com.eticaret.backend.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    /**
     * Belirli bir kullanıcıya ait tüm siparişleri getirir.
     * @param userId Kullanıcının ID'si
     * @return Kullanıcının sipariş listesi
     */
    List<Order> findByUserUserId(Long userId);
}
