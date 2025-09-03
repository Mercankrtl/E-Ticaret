// src/main/java/com/eticaret/backend/exception/UserNotFoundException.java
package com.eticaret.backend.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
}