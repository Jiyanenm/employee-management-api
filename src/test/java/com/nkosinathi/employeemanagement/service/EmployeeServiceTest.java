package com.nkosinathi.employeemanagement.service;

import com.nkosinathi.employeemanagement.dto.EmployeeRequest;
import com.nkosinathi.employeemanagement.model.Employee;
import com.nkosinathi.employeemanagement.repository.EmployeeRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


class EmployeeServiceTest {


    @Mock
    private EmployeeRepository repository;


    @InjectMocks
    private EmployeeService service;


    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void shouldGetAllEmployees() throws Exception {

        Employee employee = new Employee();

        employee.setId("1");
        employee.setName("Tester Jiyane");
        employee.setDepartment("Testing Department");


        when(repository.findAll())
                .thenReturn(List.of(employee));


        List<Employee> result =
                service.getAllEmployees();


        assertEquals(1,result.size());

        assertEquals(
                "Tester Jiyane",
                result.get(0).getName()
        );


        verify(repository)
                .findAll();
    }


}