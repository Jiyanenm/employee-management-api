package com.nkosinathi.employeemanagement.service;

import com.nkosinathi.employeemanagement.dto.EmployeeRequest;
import com.nkosinathi.employeemanagement.exception.ResourceNotFoundException;
import com.nkosinathi.employeemanagement.model.Employee;
import com.nkosinathi.employeemanagement.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public String saveEmployee(EmployeeRequest request) throws Exception {

        Employee employee = new Employee();

        employee.setName(request.getName());
        employee.setEmail(request.getEmail());
        employee.setDepartment(request.getDepartment());
        employee.setStatus(request.getStatus());

        return repository.save(employee);
    }
    public Employee getEmployeeById(String id) throws Exception {

        Employee employee = repository.findById(id);

        if (employee == null) {
            throw new ResourceNotFoundException("Employee not found.");
        }

        return employee;
    }

    public List<Employee> getAllEmployees() throws Exception {
        return repository.findAll();
    }
    public void updateEmployee(String id, EmployeeRequest request) throws Exception {

        Employee existingEmployee = repository.findById(id);

        if (existingEmployee == null) {
            throw new ResourceNotFoundException("Employee not found.");
        }

        Employee employee = new Employee();

        employee.setName(request.getName());
        employee.setEmail(request.getEmail());
        employee.setDepartment(request.getDepartment());
        employee.setStatus(request.getStatus());

        repository.update(id, employee);
    }
    public void deleteEmployee(String id) throws Exception {

        Employee existingEmployee = repository.findById(id);

        if (existingEmployee == null) {
            throw new ResourceNotFoundException("Employee not found.");
        }

        repository.delete(id);
    }
    public List<Employee> searchByName(String name) throws Exception {
        return repository.searchByName(name);
    }

    public List<Employee> searchByDepartment(String department) throws Exception {
        return repository.searchByDepartment(department);
    }

    public List<Employee> searchByStatus(String status) throws Exception {
        return repository.searchByStatus(status);
    }
}