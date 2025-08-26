package com.eticaret.backend.repository;

import com.eticaret.backend.model.ProductLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductLogRepository extends JpaRepository<ProductLog, Long> {

    // User entity’sindeki userId’ye göre logları getir
    List<ProductLog> findByUserUserId(Long userId);
}
