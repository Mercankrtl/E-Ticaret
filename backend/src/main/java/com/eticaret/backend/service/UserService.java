package com.eticaret.backend.service;

import com.eticaret.backend.model.User;
import com.eticaret.backend.repository.UserRepository;
import com.eticaret.backend.exception.*; // custom exceptionları import et
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^(?=.*[0-9])(?=.*[!@#$%^&*])[A-Za-z0-9!@#$%^&*]{6,}$");

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User registerUser(String username, String email, String password,
                             String firstName, String lastName,
                             String gender, String dateOfBirth) {

        if (userRepository.existsByEmail(email)) {
            throw new UserAlreadyExistsException("Email zaten kayıtlı.");
        }
        if (userRepository.existsByUsername(username)) {
            throw new UserAlreadyExistsException("Kullanıcı adı zaten alınmış.");
        }
        if (!PASSWORD_PATTERN.matcher(password).matches()) {
            throw new InvalidPasswordException("Şifre minimum 6 karakter, 1 rakam ve 1 özel karakter içermeli.");
        }

        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPasswordHash(passwordEncoder.encode(password));
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setGender(gender);
        user.setCreatedAt(LocalDateTime.now());

       /* if (dateOfBirth != null && !dateOfBirth.isBlank()) {
            try {
                user.setDateOfBirth(LocalDate.parse(dateOfBirth));
            } catch (Exception ex) {
                throw new InvalidDateException("dateOfBirth formatı yyyy-MM-dd olmalı");
            }
        }*/

        return userRepository.save(user);
    }

    public User loginUser(String emailOrUsername, String password) {

        User user = userRepository.findByEmail(emailOrUsername)
                .orElse(userRepository.findByUsername(emailOrUsername)
                        .orElseThrow(() -> new UserNotFoundException("Kullanıcı bulunamadı")));

        if (user.getPasswordHash() == null) {
            throw new InvalidPasswordException("Kullanıcı şifresi bulunamadı.");
        }

        if (!passwordEncoder.matches(password, user.getPasswordHash())) {
            throw new InvalidPasswordException("Şifre hatalı.");
        }

        user.setLastLogin(LocalDateTime.now());
        return userRepository.save(user);
    }
}
