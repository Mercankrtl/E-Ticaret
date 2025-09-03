package com.eticaret.backend.controller;

import com.eticaret.backend.dto.AuthResponse;
import com.eticaret.backend.dto.LoginRequest;
import com.eticaret.backend.dto.SignupRequest;
import com.eticaret.backend.model.User;
import com.eticaret.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public AuthResponse signup(@RequestBody SignupRequest request) throws Exception {
        User u = userService.registerUser(
                request.getUsername(),
                request.getEmail(),
                request.getPassword(),
                request.getFirstName(),
                request.getLastName(),
                request.getGender(),
                request.getDateOfBirth()
        );
        return AuthResponse.from(u);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest request) throws Exception {
        User u = userService.loginUser(request.getEmailOrUsername(), request.getPassword());
        return AuthResponse.from(u);
    }

    @GetMapping("/")
    public Iterable<User> getAllUsers() {
        return userService.getAllUsers();
    }
}
