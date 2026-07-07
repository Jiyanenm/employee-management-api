package com.nkosinathi.employeemanagement.controller;

import com.nkosinathi.employeemanagement.dto.ApiResponse;
import com.nkosinathi.employeemanagement.dto.EmployeeRequest;
import com.nkosinathi.employeemanagement.model.Employee;
import com.nkosinathi.employeemanagement.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@Tag(
        name = "Employee Management",
        description = "APIs for managing employee records"
)
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @PostMapping
    @Operation(
            summary = "Create a new employee",
            description = "Creates a new employee record and returns the employee ID."
    )
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
    @Operation(
            summary = "Get all employees",
            description = "Retrieves all employee records."
    )
    public ResponseEntity<ApiResponse<List<Employee>>> getAllEmployees()
            throws Exception {

        List<Employee> employees = service.getAllEmployees();

        ApiResponse<List<Employee>> response =
                new ApiResponse<>(
                        true,
                        "Employees retrieved successfully.",
                        employees
                );

        return ResponseEntity.ok(response);
    }


    @GetMapping("/{id}")
    @Operation(
            summary = "Get employee by ID",
            description = "Retrieves an employee using their unique ID."
    )
    public ResponseEntity<ApiResponse<Employee>> getEmployeeById(
            @Parameter(description = "Employee ID")
            @PathVariable String id) throws Exception {

        Employee employee = service.getEmployeeById(id);

        ApiResponse<Employee> response =
                new ApiResponse<>(
                        true,
                        "Employee retrieved successfully.",
                        employee
                );

        return ResponseEntity.ok(response);
    }


    @PutMapping("/{id}")
    @Operation(
            summary = "Update an employee",
            description = "Updates an existing employee record."
    )
    public ResponseEntity<ApiResponse<String>> updateEmployee(
            @Parameter(description = "Employee ID")
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
    @Operation(
            summary = "Delete an employee",
            description = "Deletes an employee by ID."
    )
    public ResponseEntity<ApiResponse<String>> deleteEmployee(
            @Parameter(description = "Employee ID")
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
    @Operation(
            summary = "Search employees by name",
            description = "Returns employees whose names match the supplied value."
    )
    public ResponseEntity<ApiResponse<List<Employee>>> searchByName(
            @RequestParam String name)
            throws Exception {

        List<Employee> employees = service.searchByName(name);

        ApiResponse<List<Employee>> response =
                new ApiResponse<>(
                        true,
                        "Search completed successfully.",
                        employees
                );

        return ResponseEntity.ok(response);
    }


    @GetMapping("/search/department")
    @Operation(
            summary = "Search employees by department",
            description = "Returns employees belonging to a specific department."
    )
    public ResponseEntity<ApiResponse<List<Employee>>> searchByDepartment(
            @RequestParam String department)
            throws Exception {

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
    @Operation(
            summary = "Search employees by status",
            description = "Returns employees matching the supplied employment status."
    )
    public ResponseEntity<ApiResponse<List<Employee>>> searchByStatus(
            @RequestParam String status)
            throws Exception {

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
