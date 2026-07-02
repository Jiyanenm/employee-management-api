package com.nkosinathi.employeemanagement.controller;

import com.nkosinathi.employeemanagement.dto.ApiResponse;
import com.nkosinathi.employeemanagement.dto.EmployeeRequest;
import com.nkosinathi.employeemanagement.model.Employee;
import com.nkosinathi.employeemanagement.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<String>> addEmployee(
            @Valid @RequestBody EmployeeRequest request) throws Exception {

        String id = service.saveEmployee(request);

        ApiResponse<String> response =
                new ApiResponse<>(
                        true,
                        "Employee created successfully.",
                        id
                );

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Employee>>> getAllEmployees()
            throws Exception {

        List<Employee> employees =
                service.getAllEmployees();

        ApiResponse<List<Employee>> response =
                new ApiResponse<>(
                        true,
                        "Employees retrieved successfully.",
                        employees
                );

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Employee>> getEmployeeById(
            @PathVariable String id) throws Exception {

        Employee employee =
                service.getEmployeeById(id);

        ApiResponse<Employee> response =
                new ApiResponse<>(
                        true,
                        "Employee retrieved successfully.",
                        employee
                );

        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> updateEmployee(
            @PathVariable String id,
            @Valid @RequestBody EmployeeRequest request)
            throws Exception {

        service.updateEmployee(id, request);

        ApiResponse<String> response =
                new ApiResponse<>(
                        true,
                        "Employee updated successfully.",
                        id
                );

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteEmployee(
            @PathVariable String id)
            throws Exception {

        service.deleteEmployee(id);

        ApiResponse<String> response =
                new ApiResponse<>(
                        true,
                        "Employee deleted successfully.",
                        id
                );

        return ResponseEntity.ok(response);
    }
    @GetMapping("/search/name")
    public ResponseEntity<ApiResponse<List<Employee>>> searchByName(
            @RequestParam String name)
            throws Exception {

        List<Employee> employees =
                service.searchByName(name);

        ApiResponse<List<Employee>> response =
                new ApiResponse<>(
                        true,
                        "Search completed successfully.",
                        employees
                );

        return ResponseEntity.ok(response);
    }
    @GetMapping("/search/department")
    public ResponseEntity<ApiResponse<List<Employee>>> searchByDepartment(
            @RequestParam String department) throws Exception {

        List<Employee> employees = service.searchByDepartment(department);

        ApiResponse<List<Employee>> response =
                new ApiResponse<>(
                        true,
                        "Employees retrieved successfully.",
                        employees
                );

        return ResponseEntity.ok(response);
    }
    @GetMapping("/search/status")
    public ResponseEntity<ApiResponse<List<Employee>>> searchByStatus(
            @RequestParam String status) throws Exception {

        List<Employee> employees = service.searchByStatus(status);

        ApiResponse<List<Employee>> response =
                new ApiResponse<>(
                        true,
                        "Employees retrieved successfully.",
                        employees
                );

        return ResponseEntity.ok(response);
    }
}