// src/main/java/com/eticaret/backend/exception/InvalidPasswordException.java
package com.eticaret.backend.exception;

public class InvalidPasswordException extends RuntimeException {
    public InvalidPasswordException(String message) {
        super(message);
    }
}