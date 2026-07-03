````markdown
# 🚀 Employee Management API

<div align="center">

![Java](https://img.shields.io/badge/Java-17-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen)
![Firebase](https://img.shields.io/badge/Firebase-Firestore-FFCA28)
![Maven](https://img.shields.io/badge/Maven-Build-blue)
![Render](https://img.shields.io/badge/Hosted%20on-Render-46E3B7)
![License](https://img.shields.io/badge/License-MIT-green)

### A Production-Ready RESTful Employee Management API built with Java 17, Spring Boot 3 & Firebase Firestore

### 🌐 Live API

https://employee-management-api-1-j5k2.onrender.com

</div>

---

# 📖 Table of Contents

- [Overview](#-overview)
- [Features](#-features)
- [Technology Stack](#-technology-stack)
- [Architecture](#-architecture)
- [Project Structure](#-project-structure)
- [API Endpoints](#-rest-api-endpoints)
- [Request & Response Examples](#-sample-request)
- [Validation](#-validation)
- [Exception Handling](#-global-exception-handling)
- [Firebase Configuration](#-firebase-configuration)
- [Running Locally](#-running-the-project-locally)
- [Deployment](#-deployment)
- [Testing](#-testing)
- [Roadmap](#-roadmap)
- [Skills Demonstrated](#-skills-demonstrated)
- [Author](#-author)
- [License](#-license)

---

# 📌 Overview

The **Employee Management API** is a cloud-hosted RESTful web service designed to manage employee records using **Google Firebase Firestore** as the database.

This project demonstrates enterprise-level backend development practices including:

- ✅ Layered Architecture
- ✅ Dependency Injection
- ✅ RESTful API Design
- ✅ Jakarta Bean Validation
- ✅ Centralized Exception Handling
- ✅ Secure Firebase Authentication
- ✅ Cloud Deployment
- ✅ Clean Code Principles

---

# ✨ Features

- ✅ Create Employee
- ✅ Retrieve All Employees
- ✅ Retrieve Employee by ID
- ✅ Update Employee
- ✅ Delete Employee
- ✅ Search Employees
- ✅ Input Validation
- ✅ Global Exception Handling
- ✅ Standardized API Responses
- ✅ Firebase Firestore Integration
- ✅ Environment Variable Configuration
- ✅ Cloud Deployment on Render

---

# 🛠 Technology Stack

| Technology | Description |
|------------|-------------|
| ☕ Java 17 | Programming Language |
| 🌱 Spring Boot 3 | Backend Framework |
| 🔥 Firebase Firestore | NoSQL Database |
| 📦 Maven | Dependency Management |
| ☁️ Render | Cloud Deployment |
| 🧪 JUnit 5 | Unit Testing |
| 🎯 Mockito | Mocking Framework |
| 📮 Postman | API Testing |
| 🔧 Git & GitHub | Version Control |

---

# 🏗 Architecture

```text
                Client
                   │
                   ▼
        EmployeeController
                   │
                   ▼
          EmployeeService
                   │
                   ▼
       EmployeeRepository
                   │
                   ▼
      Firebase Firestore
```

---

# 📁 Project Structure

```text
employee-management-api
│
├── src
│   ├── main
│   │   ├── java
│   │   │
│   │   └── com.nkosinathi.employeemanagement
│   │       ├── config
│   │       ├── controller
│   │       ├── dto
│   │       ├── exception
│   │       ├── model
│   │       ├── repository
│   │       ├── service
│   │       └── util
│   │
│   └── resources
│       └── application.properties
│
├── src/test
│
├── pom.xml
│
└── README.md
```

---

# 🌐 REST API Endpoints

| Method | Endpoint | Description |
|---------|----------|-------------|
| GET | `/api/employees` | Retrieve all employees |
| GET | `/api/employees/{id}` | Retrieve employee by ID |
| GET | `/api/employees/search` | Search employees |
| POST | `/api/employees` | Create employee |
| PUT | `/api/employees/{id}` | Update employee |
| DELETE | `/api/employees/{id}` | Delete employee |

---

# 📤 Sample Request

```json
{
  "name": "Nkosinathi Jiyane",
  "email": "nmjiyane@gmail.com",
  "department": "Information Technology",
  "status": "Active"
}
```

---

# 📥 Sample Response

```json
{
  "success": true,
  "message": "Employees retrieved successfully.",
  "data": [
    {
      "id": "Gmo4aTRHzJDXIFoE645d",
      "name": "Nkosinathi Jiyane",
      "email": "nmjiyane@gmail.com",
      "department": "Information Technology",
      "status": "Active"
    }
  ]
}
```

---

# ✅ Validation

The API validates incoming requests using **Jakarta Bean Validation**.

Supported validations include:

- Required fields
- Valid email addresses
- Non-empty values
- Invalid request handling

---

# 🚨 Global Exception Handling

Centralized exception handling is implemented using `@RestControllerAdvice`.

Handled exceptions include:

- Employee Not Found
- Validation Errors
- Illegal Arguments
- Firebase Exceptions
- Internal Server Errors
-
---

# 🔥 Firebase Configuration

Firebase credentials are securely loaded using an environment variable.

| Variable | Description |
|----------|-------------|
| `FIREBASE_CREDENTIALS` | Complete Firebase Service Account JSON |

> **Security Note**
>
> Never commit your Firebase Service Account JSON to GitHub.
> Always store credentials securely using environment variables or your hosting platform's secret management.

---

# 💻 Running the Project Locally

### Clone the repository

```bash
git clone https://github.com/<your-username>/employee-management-api.git
```

### Navigate into the project

```bash
cd employee-management-api
```

### Configure Firebase Credentials

**Windows PowerShell**

```powershell
$env:FIREBASE_CREDENTIALS="<Firebase JSON>"
```

**Linux / macOS**

```bash
export FIREBASE_CREDENTIALS='<Firebase JSON>'
```

### Run the application

```bash
mvn spring-boot:run
```

---

# ☁️ Deployment

The application is deployed to **Render** using:

- Automatic GitHub Deployments
- Secure Environment Variables
- Firebase Firestore Integration
- Production Configuration

---

# 🧪 Testing

Current testing includes:

- ✅ JUnit 5
- ✅ Mockito
- ✅ Manual API Testing
- ✅ Postman Collections

### Planned Enhancements

- REST Assured API Automation
- Selenium WebDriver
- GitHub Actions CI/CD
- Allure Reports
- Performance Testing (JMeter)

---

# 🚀 Roadmap

- Spring Security
- JWT Authentication
- Swagger / OpenAPI Documentation
- Docker Support
- Kubernetes Deployment
- Pagination
- Sorting & Filtering
- Spring Boot Actuator
- Logging & Monitoring
- API Versioning

---

# 💼 Skills Demonstrated

- Java 17
- Spring Boot
- RESTful API Development
- Firebase Firestore
- Dependency Injection
- Layered Architecture
- Exception Handling
- Bean Validation
- Maven
- Git & GitHub
- Cloud Deployment
- CI/CD Fundamentals
- Clean Code Principles

---

# 👨‍💻 Author

**Nkosinathi Jiyane**

**QA Engineer • SDET • Java Backend Developer**

📧 **Email:** nmjiyane1@gmail.com

🔗 **LinkedIn:** https://www.linkedin.com/in/<your-linkedin>

💻 **GitHub:** https://www.linkedin.com/in/nkosinathi-michael-jiyane-21161292<your-github>

---

# 📄 License

This project is licensed under the **MIT License**.

---

<div align="center">

⭐ **If you found this project useful, consider giving it a Star!**

Built with ❤️ using **Java**, **Spring Boot**, and **Firebase Firestore**

</div>
````
