package com.eticaret.backend.repository;

import com.eticaret.backend.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TagRepository extends JpaRepository<Tag, Integer> {
    // Optional ile dönmesini sağlıyoruz
    Optional<Tag> findByName(String name);
}
