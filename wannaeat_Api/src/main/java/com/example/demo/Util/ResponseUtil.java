package com.example.demo.Util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseUtil {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static <T> ResponseEntity<Map<String, Object>> sendResponse(
            String message, T data, HttpStatus statusCode) {
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("success", true);
        responseBody.put("message", message);
        responseBody.put("data", data);
//        responseBody.put("paginationInfo", paginationInfo);

        return ResponseEntity.status(statusCode).body(responseBody);
    }

    public static <T> ResponseEntity<Map<String, Object>> sendError(
            String message, HttpStatus statusCode, T error) {
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("success", false);
        responseBody.put("message", message);
        responseBody.put("error", error);

        return ResponseEntity.status(statusCode).body(responseBody);
    }
}
