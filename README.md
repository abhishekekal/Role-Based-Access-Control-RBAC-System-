# Spring Boot + React JWT Role-Based Access Control (RBAC)

## Overview

This project implements **Role-Based Access Control (RBAC)** using **Spring Boot, Spring Security, JWT (JSON Web Token), and React**.



Users can:

* Register an account
* Login securely
* Receive a JWT token
* Access APIs based on assigned roles (**USER** or **ADMIN**)

The **backend provides secure APIs** while the **frontend provides a user interface for authentication and role-based dashboards**.

---
🎥 Project Demo Video

https://drive.google.com/file/d/10UP53blfz2CYcxv2dYj9f8c9om8fBiY0/view?usp=sharing

# Features

## Backend (Spring Boot)

* User Registration
* User Login
* JWT Token Generation
* Role-Based Authorization
* Spring Security Integration
* BCrypt Password Encryption
* REST API Architecture
* MySQL Database Integration

## Frontend (React)

* Login Page
* Register Page
* Role-Based Dashboard
* Protected Routes
* JWT Token Storage
* API Integration using Axios

---

# Technologies Used

## Backend

* Java
* Spring Boot
* Spring Security
* Spring Data JPA
* JWT (JSON Web Token)
* MySQL
* Maven
* Lombok

## Frontend

* React
* React Router
* Axios
* JWT Decode
* CSS

---

# Project Structure

## Repository Structure

```
RBAC-JWT-FullStack
│
├── backend
│     └── Spring Boot Application
│
├── frontend
│     └── React Application
│
└── README.md
```

---

# Backend Structure

```
com.example.RBAC
│
├── config
│      SecurityConfig.java
│
├── controller
│      AuthController.java
│      AdminController.java
│      UserController.java
│      PublicController.java
│
├── dto
│      AuthResponse.java
│      LoginRequest.java
│      RegisterRequest.java
│
├── entity
│      User.java
│      Role.java
│
├── repository
│      UserRepository.java
│
├── security
│      JwtService.java
│      JwtFilter.java
│
├── service
│      AuthService.java
│      CustomUserDetailsService.java
│
└── RbacApplication.java
```

---

# Frontend Structure

```
src
│
├── api
│      api.ts
│
├── pages
│      Login.tsx
│      Register.tsx
│      Dashboard.tsx
│
├── components
│      UserCard.tsx
│      AdminCard.tsx
│
├── routes
│      ProtectedRoute.tsx
│
├── types
│      AuthTypes.ts
│
├── App.tsx
└── main.tsx
```

---

# API Endpoints

## Register

**POST**

```
/api/auth/register
```

### Request Body

```json
{
  "name": "Abhishek",
  "email": "abhishek@gmail.com",
  "password": "12345",
  "role": "USER"
}
```

---

## Login

**POST**

```
/api/auth/login
```

### Request Body

```json
{
  "email": "abhishek@gmail.com",
  "password": "12345"
}
```

### Response

```json
{
  "token": "JWT_TOKEN"
}
```

---

# Public API

**GET**

```
/api/public
```

Accessible by **anyone**.

---

# User API

**GET**

```
/api/user
```

Accessible only for **USER role**.

### Header

```
Authorization: Bearer JWT_TOKEN
```

---

# Admin API

**GET**

```
/api/admin
```

Accessible only for **ADMIN role**.

### Header

```
Authorization: Bearer JWT_TOKEN
```

---

# Authentication Flow

1. User registers with role **USER** or **ADMIN**
2. Password is encrypted using **BCrypt**
3. User logs in with credentials
4. Server generates **JWT token**
5. React stores the token in **localStorage**
6. React sends the token in **request headers**
7. **JWT Filter validates the token**
8. Access is granted based on the **user's role**

---

# Database Configuration

Add the following configuration in **application.properties**.

```
spring.datasource.url=jdbc:mysql://localhost:3306/demo_db
spring.datasource.username=root
spring.datasource.password=root

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

# Running the Backend

### 1. Clone the repository

```
git clone https://github.com/yourusername/rbac-jwt-fullstack.git
```

### 2. Navigate to backend

```
cd backend
```

### 3. Run the application

```
mvn spring-boot:run
```

### Server URL

```
http://localhost:8080
```

---

# Running the Frontend

### 1. Navigate to frontend folder

```
cd frontend
```

### 2. Install dependencies

```
npm install
```

### 3. Run React application

```
npm run dev
```

### Frontend URL

```
http://localhost:5173
```

---

# Testing

You can test the application using:

* React Frontend
* Postman
* Insomnia

---

# Future Improvements

* Refresh Token Implementation
* Logout with Token Blacklist
* Admin Dashboard
* User Management Panel
* Docker Deployment

---

# Author

**Abhishek Hanmant Ekal**
Java Full Stack Developer

LinkedIn
https://www.linkedin.com/in/abhishek-ekal-57642425b

---

# License

This project is **open source** and available for **learning and educational purposes**.
