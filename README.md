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

https://employee-management-api-2-0ygx.onrender.com/

</div>


### 🌐 Swagger

https://employee-management-api-2-0ygx.onrender.com/swagger-ui/index.html
---

# 📖 Table of Contents

- [Overview](#-overview)
- [Features](#-features)
- [Technology Stack](#-technology-stack)
- [Architecture](#-architecture)
- [Project Structure](#-project-structure)
- [REST API Endpoints](#-rest-api-endpoints)
- [Sample Request](#-sample-request)
- [Sample Response](#-sample-response)
- [Validation](#-validation)
- [Global Exception Handling](#-global-exception-handling)
- [Firebase Configuration](#-firebase-configuration)
- [Running the Project Locally](#-running-the-project-locally)
- [Deployment](#-deployment)
- [Testing](#-testing)
- [Roadmap](#-roadmap)
- [Skills Demonstrated](#-skills-demonstrated)
- [Author](#-author)
- [License](#-license)

---

# 📌 Overview

The **Employee Management API** is a cloud-hosted RESTful web service designed to manage employee records using **Google Firebase Firestore**.

## ✨ Features

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

## 🛠 Technology Stack

| Technology | Description |
|---|---|
| Java 17 | Programming Language |
| Spring Boot 3 | Backend Framework |
| Firebase Firestore | NoSQL Database |
| Maven | Dependency Management |
| Render | Cloud Deployment |
| JUnit 5 | Unit Testing |
| Mockito | Mocking Framework |
| Postman | API Testing |
| Git & GitHub | Version Control |

## 🏗 Architecture

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

## 📁 Project Structure

```text
employee-management-api
├── src
│   ├── main
│   │   ├── java
│   │   └── com.nkosinathi.employeemanagement
│   └── resources
├── src/test
├── pom.xml
└── README.md
```

## 🌐 REST API Endpoints

| Method | Endpoint | Description |
|---|---|---|
| GET | `/api/employees` | Retrieve all employees |
| GET | `/api/employees/{id}` | Retrieve employee by ID |
| GET | `/api/employees/search` | Search employees |
| POST | `/api/employees` | Create employee |
| PUT | `/api/employees/{id}` | Update employee |
| DELETE | `/api/employees/{id}` | Delete employee |

## 📤 Sample Request

```json
{
  "name":"Nkosinathi Jiyane",
  "email":"nmjiyane@gmail.com",
  "department":"Information Technology",
  "status":"Active"
}
```

## 📥 Sample Response

```json
{
  "success": true,
  "message": "Employees retrieved successfully.",
  "data":[{"id":"Gmo4aTRHzJDXIFoE645d","name":"Nkosinathi Jiyane","email":"nmjiyane@gmail.com","department":"Information Technology","status":"Active"}]
}
```

## ✅ Validation

- Required fields
- Valid email addresses
- Non-empty values
- Invalid request handling

## 🚨 Global Exception Handling

Handled exceptions:

- Employee Not Found
- Validation Errors
- Illegal Arguments
- Firebase Exceptions
- Internal Server Errors

## 🔥 Firebase Configuration

| Variable | Description |
|---|---|
| `FIREBASE_CREDENTIALS` | Firebase Service Account JSON |

> Never commit Firebase credentials to GitHub.

## 💻 Running the Project Locally

```bash
git clone https://github.com/<your-username>/employee-management-api.git
cd employee-management-api
```

Windows PowerShell

```powershell
$env:FIREBASE_CREDENTIALS="<Firebase JSON>"
```

Linux/macOS

```bash
export FIREBASE_CREDENTIALS='<Firebase JSON>'
mvn spring-boot:run
```

## ☁️ Deployment

- Automatic GitHub Deployments
- Secure Environment Variables
- Firebase Firestore Integration
- Production Configuration

## 🧪 Testing

- JUnit 5
- Mockito
- Manual API Testing
- Postman Collections

## 🚀 Roadmap

- Spring Security
- JWT Authentication
- Swagger / OpenAPI
- Docker
- Kubernetes
- Pagination
- Sorting & Filtering
- Spring Boot Actuator
- Logging & Monitoring
- API Versioning

## 💼 Skills Demonstrated

Java 17 • Spring Boot • REST APIs • Firebase Firestore • Dependency Injection • Bean Validation • Exception Handling • Maven • Git & GitHub • Cloud Deployment • Clean Code

## 👨‍💻 Author

**Nkosinathi Jiyane**

QA Engineer • SDET • Java Backend Developer

📧 nmjiyane1@gmail.com

🔗 LinkedIn: https://www.linkedin.com/in/<your-linkedin>

💻 GitHub: https://github.com/<your-github>

## 📄 License

Licensed under the MIT License.

---

<div align="center">

⭐ If you found this project useful, consider giving it a Star!

Built with ❤️ using Java, Spring Boot & Firebase Firestore

</div>
