# Use Java 17
FROM eclipse-temurin:17-jdk

WORKDIR /app

# Copy project files
COPY . .

# Give execute permission to Maven Wrapper
RUN chmod +x mvnw

# Build the Spring Boot application
RUN ./mvnw clean package -DskipTests

# Render provides the PORT environment variable
EXPOSE 8080

# Start application
ENTRYPOINT ["sh", "-c", "java -jar target/employee-management-api-0.0.1-SNAPSHOT.jar --server.port=${PORT:-8080}"]