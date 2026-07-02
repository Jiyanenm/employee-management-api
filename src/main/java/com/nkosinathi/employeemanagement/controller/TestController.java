package com.nkosinathi.employeemanagement.controller;

import com.nkosinathi.employeemanagement.service.FirestoreService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private final FirestoreService firestoreService;

    public TestController(FirestoreService firestoreService) {
        this.firestoreService = firestoreService;
    }

    @GetMapping("/api/test/firestore")
    public String testFirestore() {
        return firestoreService.testConnection();
    }
}
