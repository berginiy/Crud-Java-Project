A comprehensive RESTful API built with Spring Boot 3, demonstrating CRUD operations, validation, error handling, and best practices for enterprise application development.
🚀 Features

RESTful API Design - Standard HTTP methods and status codes
User Management - Complete CRUD operations for user entities
Data Validation - Input validation with custom error messages
Error Handling - Global exception handling with structured responses
Database Integration - JPA/Hibernate with H2 in-memory database
API Documentation - Built-in documentation on home page
Health Checks - Application health monitoring endpoints

📋 API Endpoints
API Information
GET /api/v1           - API information and status
GET /api/v1/health    - Health check endpoint
User Management
GET    /api/v1/users              - Get all users
GET    /api/v1/users/{id}         - Get user by ID
GET    /api/v1/users/email/{email} - Get user by email
GET    /api/v1/users/search?q={query} - Search users by name
POST   /api/v1/users              - Create new user
PUT    /api/v1/users/{id}         - Update existing user
DELETE /api/v1/users/{id}         - Delete user
🛠️ Technology Stack

Framework: Spring Boot 3.2+
Language: Java 17+
Database: H2 (In-memory)
ORM: JPA/Hibernate
Build Tool: Maven
Validation: Bean Validation (JSR-303)

📦 Getting Started
Prerequisites

Java 17 or higher
Maven 3.6+
Git

Installation

Clone the repository
bashgit clone https://github.com/yourusername/spring-boot-rest-api-demo.git
cd spring-boot-rest-api-demo

Build the project
bashmvn clean compile

Run the application
bashmvn spring-boot:run

Access the application

Main page: http://localhost:8080
API base: http://localhost:8080/api/v1
H2 Console: http://localhost:8080/h2-console



🔧 Configuration
The application uses H2 in-memory database by default. Configuration can be found in application.properties:
properties# Database
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.username=sa
spring.datasource.password=

# H2 Console
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

# JPA
spring.jpa.hibernate.ddl-auto=create-drop
spring.jpa.show-sql=true
📝 API Usage Examples
Create a User
bashcurl -X POST http://localhost:8080/api/v1/users \
  -H "Content-Type: application/json" \
  -d '{
    "firstName": "John",
    "lastName": "Doe",
    "email": "john.doe@example.com"
  }'
Get All Users
bashcurl http://localhost:8080/api/v1/users
Search Users
bashcurl http://localhost:8080/api/v1/users/search?q=John
Update User
bashcurl -X PUT http://localhost:8080/api/v1/users/1 \
  -H "Content-Type: application/json" \
  -d '{
    "firstName": "Jane",
    "lastName": "Smith",
    "email": "jane.smith@example.com"
  }'
Delete User
bashcurl -X DELETE http://localhost:8080/api/v1/users/1
📊 Response Format
All API responses follow a consistent structure:
Success Response
json{
  "data": {
    "id": 1,
    "firstName": "John",
    "lastName": "Doe",
    "email": "john.doe@example.com",
    "createdAt": "2024-01-15T10:30:00",
    "updatedAt": "2024-01-15T10:30:00"
  },
  "message": "User created successfully",
  "count": 1
}
Error Response
json{
  "error": "Bad Request",
  "message": "Email is required",
  "timestamp": 1642234567890
}
🏗️ Project Structure
src/
├── main/
│   ├── java/com/example/demo/
│   │   ├── controller/          # REST Controllers
│   │   │   ├── UserController.java
│   │   │   ├── HelloController.java
│   │   │   ├── RootController.java
│   │   │   └── CustomErrorController.java
│   │   ├── model/               # JPA Entities
│   │   │   └── User.java
│   │   ├── repository/          # Data Access Layer
│   │   │   └── UserRepository.java
│   │   ├── service/             # Business Logic
│   │   │   └── UserService.java
│   │   └── DemoApplication.java # Main Application Class
│   └── resources/
│       └── application.properties
🧪 Testing
You can test the API using:

Built-in Documentation - Visit http://localhost:8080 for interactive documentation
H2 Console - Access database at http://localhost:8080/h2-console
curl - Use the examples provided above
Postman - Import the endpoints for testing
Any REST client - The API follows standard REST conventions

🔍 Database Access
Access the H2 database console at: http://localhost:8080/h2-console
Connection Details:

JDBC URL: jdbc:h2:mem:testdb
User Name: sa
Password: (leave empty)

🚦 HTTP Status Codes
The API uses standard HTTP status codes:

200 - OK (Success)
201 - Created (Resource created)
400 - Bad Request (Validation error)
404 - Not Found (Resource not found)
500 - Internal Server Error

🔧 Development
Adding New Features

Create entity in model/ package
Create repository interface in repository/ package
Implement business logic in service/ package
Create REST controller in controller/ package

Database Changes
The application uses spring.jpa.hibernate.ddl-auto=create-drop, so the database schema is automatically created and dropped on application restart.
