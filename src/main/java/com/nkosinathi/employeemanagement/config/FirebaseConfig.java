package com.nkosinathi.employeemanagement.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@Configuration
@ConditionalOnProperty(
        name = "firebase.enabled",
        havingValue = "true",
        matchIfMissing = true
)
public class FirebaseConfig {

    @Bean
    public Firestore firestore() throws IOException {

        String credentialsPath = System.getenv("FIREBASE_CREDENTIALS");

        if (credentialsPath == null || credentialsPath.isBlank()) {
            throw new IOException("FIREBASE_CREDENTIALS environment variable is not set.");
        }

        try (InputStream serviceAccount = new FileInputStream(credentialsPath)) {

            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .build();

            if (FirebaseApp.getApps().isEmpty()) {
                FirebaseApp.initializeApp(options);
            }

            return FirestoreClient.getFirestore();
        }
    }
}