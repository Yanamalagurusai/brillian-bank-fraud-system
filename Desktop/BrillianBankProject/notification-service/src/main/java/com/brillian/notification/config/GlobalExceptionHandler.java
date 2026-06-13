package com.brillian.notification.config;

import com.brillian.notification.dto.MessageResponse;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<MessageResponse> handleIllegalArgument(IllegalArgumentException ex) {
        return ResponseEntity.badRequest().body(new MessageResponse(ex.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<MessageResponse> handleValidation(MethodArgumentNotValidException ex) {
        String message = ex.getBindingResult().getFieldErrors().stream()
                .findFirst()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .orElse("Validation failed");
        return ResponseEntity.badRequest().body(new MessageResponse(message));
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<MessageResponse> handleConstraintViolation(ConstraintViolationException ex) {
        String message = ex.getConstraintViolations().stream()
                .findFirst()
                .map(violation -> violation.getPropertyPath() + ": " + violation.getMessage())
                .orElse("Validation failed");
        return ResponseEntity.badRequest().body(new MessageResponse(message));
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<MessageResponse> handleMissingRequestParameter(MissingServletRequestParameterException ex) {
        return ResponseEntity.badRequest().body(new MessageResponse(ex.getParameterName() + " is required"));
    }
}
