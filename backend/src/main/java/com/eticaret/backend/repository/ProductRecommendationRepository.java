package com.eticaret.backend.repository;

import com.eticaret.backend.model.ProductRecommendation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductRecommendationRepository extends JpaRepository<ProductRecommendation, Integer> {

    List<ProductRecommendation> findByProductId(Integer productId);
}

