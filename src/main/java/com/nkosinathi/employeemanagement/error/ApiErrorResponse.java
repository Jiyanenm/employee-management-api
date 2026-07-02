package com.nkosinathi.employeemanagement.error;

import java.time.LocalDateTime;

public class ApiErrorResponse {

    private LocalDateTime timestamp;
    private int status;
    private String error;
    private String message;
    private String errorCode;

    public ApiErrorResponse(LocalDateTime timestamp,
                            int status,
                            String error,
                            String message,
                            String errorCode) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.message = message;
        this.errorCode = errorCode;
    }

    // getters
}