// src/main/java/com/eticaret/backend/service/UserService.java
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

    public List<User> getAllUsers() { return userRepository.findAll(); }
    public Optional<User> getUserById(Long id) { return userRepository.findById(id); }
    public User createUser(User user) { return userRepository.save(user); }
    public User updateUser(User user) { return userRepository.save(user); }
    public void deleteUser(Long id) { userRepository.deleteById(id); }
    public Optional<User> getUserByEmail(String email) { return userRepository.findByEmail(email); }
    public Optional<User> getUserByUsername(String username) { return userRepository.findByUsername(username); }
}
