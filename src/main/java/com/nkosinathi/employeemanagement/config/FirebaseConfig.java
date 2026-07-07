package com.nkosinathi.employeemanagement.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.io.FileInputStream;

@Configuration
public class FirebaseConfig {

    @Bean
    public Firestore firestore() throws Exception {

        String path = System.getenv("FIREBASE_CREDENTIALS");

        System.out.println("FIREBASE_CREDENTIALS = " + path);

        File firebaseFile = new File(path);

        System.out.println("Absolute path = " + firebaseFile.getAbsolutePath());
        System.out.println("Exists = " + firebaseFile.exists());

        if (!firebaseFile.exists()) {
            throw new IllegalStateException(
                    "Firebase key missing: " + firebaseFile.getAbsolutePath()
            );
        }

        try (FileInputStream serviceAccount = new FileInputStream(firebaseFile)) {

            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(
                            GoogleCredentials.fromStream(serviceAccount)
                    )
                    .build();

            if (FirebaseApp.getApps().isEmpty()) {
                FirebaseApp.initializeApp(options);
            }
        }

        return FirestoreClient.getFirestore();
    }
}