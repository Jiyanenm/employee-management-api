package com.nkosinathi.employeemanagement.error;

public enum ErrorCode {

    EMPLOYEE_NOT_FOUND("EMP_404_001"),
    EMPLOYEE_ALREADY_EXISTS("EMP_409_001"),
    VALIDATION_FAILED("EMP_400_001"),
    INTERNAL_ERROR("EMP_500_001");

    private final String code;

    ErrorCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}