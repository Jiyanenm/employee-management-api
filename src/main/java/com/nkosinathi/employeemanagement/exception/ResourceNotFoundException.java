package com.nkosinathi.employeemanagement.exception;

import com.nkosinathi.employeemanagement.dto.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<String>> handleGeneral(Exception ex) {

        ex.printStackTrace();

        ApiResponse<String> response =
                new ApiResponse<>(
                        false,
                        ex.toString(),
                        null
                );

        return ResponseEntity
                .status(500)
                .body(response);
    }
}