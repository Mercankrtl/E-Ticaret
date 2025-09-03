package com.eticaret.backend.dto;

import com.eticaret.backend.model.User;

public class AuthResponse {
    private Long userId;
    private String username;
    private String email;
    private String firstName;
    private String lastName;

    public static AuthResponse from(User u) {
        AuthResponse r = new AuthResponse();
        r.userId = u.getUserId();
        r.username = u.getUsername();
        r.email = u.getEmail();
        r.firstName = u.getFirstName();
        r.lastName = u.getLastName();
        return r;
    }

    // Getters
    public Long getUserId() { return userId; }
    public String getUsername() { return username; }
    public String getEmail() { return email; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
}
