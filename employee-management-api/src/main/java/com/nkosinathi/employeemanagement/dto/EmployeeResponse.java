package com.nkosinathi.employeemanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeResponse {

    private String id;
    private String name;
    private String email;
    private String department;
    private String status;

}