package com.eticaret.backend.service;

import com.eticaret.backend.model.User;
import com.eticaret.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Tüm kullanıcıları getir
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // ID'ye göre kullanıcı getir
    public Optional<User> getUserById(Integer id) {
        return userRepository.findById(id);
    }

    // Yeni kullanıcı ekle
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // Kullanıcı güncelle
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    // Kullanıcı sil
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    // E-posta veya kullanıcı adı ile arama (isteğe bağlı)
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
