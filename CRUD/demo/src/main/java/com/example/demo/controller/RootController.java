package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RootController {

    @GetMapping("/")
    @ResponseBody
    public String home() {
        return """
            <!DOCTYPE html>
            <html>
            <head>
                <title>Spring Boot Demo</title>
                <meta charset="UTF-8">
                <style>
                    body { 
                        font-family: Arial, sans-serif; 
                        max-width: 800px; 
                        margin: 50px auto; 
                        padding: 20px;
                        background-color: #f5f5f5;
                    }
                    .container {
                        background: white;
                        padding: 30px;
                        border-radius: 10px;
                        box-shadow: 0 2px 10px rgba(0,0,0,0.1);
                    }
                    h1 { color: #28a745; }
                    .endpoint {
                        background: #f8f9fa;
                        padding: 10px;
                        margin: 10px 0;
                        border-left: 4px solid #007bff;
                        font-family: monospace;
                    }
                    .method {
                        color: #28a745;
                        font-weight: bold;
                    }
                </style>
            </head>
            <body>
                <div class="container">
                    <h1>🚀 Spring Boot Demo приложение запущено!</h1>
                    <p>Добро пожаловать! Ваше приложение работает корректно.</p>
                    
                    <h2>📋 Available REST API Endpoints:</h2>
                    
                    <h3>API Info:</h3>
                    <div class="endpoint"><span class="method">GET</span> /api/v1 - API information</div>
                    <div class="endpoint"><span class="method">GET</span> /api/v1/health - Health check</div>
                    
                    <h3>Users Resource:</h3>
                    <div class="endpoint"><span class="method">GET</span> /api/v1/users - Get all users</div>
                    <div class="endpoint"><span class="method">GET</span> /api/v1/users/{id} - Get user by ID</div>
                    <div class="endpoint"><span class="method">GET</span> /api/v1/users/email/{email} - Get user by email</div>
                    <div class="endpoint"><span class="method">GET</span> /api/v1/users/search?q={query} - Search users</div>
                    <div class="endpoint"><span class="method">POST</span> /api/v1/users - Create new user</div>
                    <div class="endpoint"><span class="method">PUT</span> /api/v1/users/{id} - Update user</div>
                    <div class="endpoint"><span class="method">DELETE</span> /api/v1/users/{id} - Delete user</div>
                    
                    <h3>🔧 Инструменты:</h3>
                    <div class="endpoint"><a href="/h2-console" target="_blank">H2 Database Console</a></div>
                    
                    <h3>📝 Example API Usage:</h3>
                    <pre style="background: #f8f9fa; padding: 15px; border-radius: 5px;">
# Create a new user
POST /api/v1/users
Content-Type: application/json

{
    "firstName": "John",
    "lastName": "Doe",
    "email": "john.doe@example.com"
}

# Get all users
GET /api/v1/users

# Search users
GET /api/v1/users/search?q=John

# Update user
PUT /api/v1/users/1
Content-Type: application/json

{
    "firstName": "Jane",
    "lastName": "Smith",
    "email": "jane.smith@example.com"
}
                    </pre>
                </div>
            </body>
            </html>
            """;
    }
}
