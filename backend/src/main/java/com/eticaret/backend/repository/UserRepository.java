package com.eticaret.backend.repository;

import com.eticaret.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    // Kullanıcıyı username ile bulmak için
    Optional<User> findByUsername(String username);

    // Kullanıcıyı email ile bulmak için
    Optional<User> findByEmail(String email);
}
