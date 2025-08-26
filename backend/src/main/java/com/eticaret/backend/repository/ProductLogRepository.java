package com.eticaret.backend.repository;

import com.eticaret.backend.model.ProductLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface ProductLogRepository extends JpaRepository<ProductLog, Integer> {

    List<ProductLog> findByUserId(Integer userId);

    List<ProductLog> findByProductId(Integer productId);
}
