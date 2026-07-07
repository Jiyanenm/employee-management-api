# Use Java 17
FROM eclipse-temurin:17-jdk

# Set working directory
WORKDIR /app

# Copy project files
COPY . .

# Give execute permission to Maven Wrapper
RUN chmod +x mvnw

# Build the application
RUN ./mvnw clean package -DskipTests

# Cloud platforms like Render expose the PORT env variable
EXPOSE 8080

ENV FIREBASE_CREDENTIALS=/app/config/serviceAccountKey.json

# Start the application
ENTRYPOINT ["java","-jar","target/employee-management-api-0.0.1-SNAPSHOT.jar"]
