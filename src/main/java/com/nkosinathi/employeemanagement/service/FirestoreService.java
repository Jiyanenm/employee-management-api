package com.nkosinathi.employeemanagement.service;

import com.google.cloud.firestore.Firestore;
import org.springframework.stereotype.Service;

@Service
public class FirestoreService {

    private final Firestore firestore;

    public FirestoreService(Firestore firestore) {
        this.firestore = firestore;
    }

    public String testConnection() {
        return "Connected to Firestore: " + firestore.getOptions().getProjectId();
    }
}
