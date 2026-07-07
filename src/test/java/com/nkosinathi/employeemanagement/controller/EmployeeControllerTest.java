package com.nkosinathi.employeemanagement.controller;


import com.nkosinathi.employeemanagement.model.Employee;
import com.nkosinathi.employeemanagement.service.EmployeeService;


import org.junit.jupiter.api.Test;


import org.mockito.Mockito;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;


import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;


import java.util.List;


import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;



@WebMvcTest(EmployeeController.class)
class EmployeeControllerTest {


    @Autowired
    private MockMvc mockMvc;


    @MockBean
    private EmployeeService service;



    @Test
    void shouldReturnAllEmployees()
            throws Exception {


        Employee employee =
                new Employee();


        employee.setId("1");
        employee.setName("Tester Jiyane");
        employee.setDepartment("Testing Department");



        when(service.getAllEmployees())
                .thenReturn(
                        List.of(employee)
                );


        mockMvc.perform(
                        get("/api/employees")
                )
                .andExpect(status().isOk());

    }

}