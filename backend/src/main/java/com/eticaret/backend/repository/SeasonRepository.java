package com.eticaret.backend.repository;

import com.eticaret.backend.model.Season;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface SeasonRepository extends JpaRepository<Season, Long> {

    Optional<Season> findByNameIgnoreCase(String name);

    // LazyInitializationException engellemek için JOIN FETCH
    @Query("SELECT s FROM Season s LEFT JOIN FETCH s.products WHERE LOWER(s.name) = LOWER(:name)")
    Optional<Season> findByNameWithProducts(@Param("name") String name);

    @Query("SELECT s FROM Season s LEFT JOIN FETCH s.products WHERE s.id = :id")
    Optional<Season> findByIdWithProducts(@Param("id") Long id);
}
