// src/main/java/com/eticaret/backend/repository/ProductTagRepository.java
package com.eticaret.backend.repository;

import com.eticaret.backend.model.ProductTag;
import com.eticaret.backend.model.ProductTagId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductTagRepository extends JpaRepository<ProductTag, ProductTagId> {
    List<ProductTag> findByProduct_Id(Long productId);
}
