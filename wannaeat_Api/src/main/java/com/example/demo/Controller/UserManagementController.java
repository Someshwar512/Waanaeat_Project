package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.User;
import com.example.demo.Service.UserService;
import com.example.demo.Util.ResponseUtil;

@RestController
@RequestMapping("/api/users")
public class UserManagementController {

    @Autowired
    private UserService userService;

//    adduser Api implemetions
    
    @PostMapping("/addUser")
    public ResponseEntity<?> addUser(@RequestBody User user) {
        try {
            userService.addUser(user);
            return ResponseUtil.sendResponse("User added successfully", user, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseUtil.sendError("Failed to add user", HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }
}

