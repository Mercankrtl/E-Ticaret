// src/main/java/com/eticaret/backend/repository/GenderRepository.java
package com.eticaret.backend.repository;

import com.eticaret.backend.model.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GenderRepository extends JpaRepository<Gender, Long> {
    Optional<Gender> findByName(String name);
}
