package com.example.demo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    public ResponseEntity<Map<String, Object>> handleError(HttpServletRequest request) {
        Object status = request.getAttribute("jakarta.servlet.error.status_code");
        Object message = request.getAttribute("jakarta.servlet.error.message");
        String errorPath = (String) request.getAttribute("jakarta.servlet.error.request_uri");

        if (status == null) {
            status = request.getAttribute("javax.servlet.error.status_code");
        }
        if (message == null) {
            message = request.getAttribute("javax.servlet.error.message");
        }
        if (errorPath == null) {
            errorPath = (String) request.getAttribute("javax.servlet.error.request_uri");
        }

        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        if (status != null) {
            try {
                httpStatus = HttpStatus.valueOf((Integer) status);
            } catch (Exception e) {
            }
        }

        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("status", status != null ? status : 500);
        errorResponse.put("error", httpStatus.getReasonPhrase());
        errorResponse.put("message", message != null ? message.toString() : "Произошла ошибка");
        errorResponse.put("path", errorPath != null ? errorPath : request.getRequestURI());
        errorResponse.put("timestamp", System.currentTimeMillis());

        return new ResponseEntity<>(errorResponse, httpStatus);
    }
}