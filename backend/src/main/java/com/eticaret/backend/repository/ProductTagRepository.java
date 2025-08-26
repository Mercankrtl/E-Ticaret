package com.eticaret.backend.repository;

import com.eticaret.backend.model.ProductTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductTagRepository extends JpaRepository<ProductTag, Integer> {
    List<ProductTag> findByProductId(Integer productId);
}

