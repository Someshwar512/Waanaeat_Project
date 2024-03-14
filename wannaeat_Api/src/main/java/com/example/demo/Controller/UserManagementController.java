package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Model.User;
import com.example.demo.Service.UserService;
import com.example.demo.Util.ResponseUtil;

@RestController
@RequestMapping("/api/users")
public class UserManagementController {

    @Autowired
    private UserService userService;

//    // Add getAllUsers API implementation
//    @GetMapping("/getAllUsers")
//    public ResponseEntity<?> getAllUsers(String role, String searchKeyword, String sortOrder, int page, int pageSize) {
//        try {
//            // Call the service method to retrieve all users
//            List<User> users = userService.getAllUsers(role, searchKeyword, sortOrder, page, pageSize);
//            // Return the response with the list of users
//            return ResponseUtil.sendResponse("Users fetched successfully", users, HttpStatus.OK);
//        } catch (Exception e) {
//            // Handle exceptions and return an error response
//            return ResponseUtil.sendError("Failed to fetch users", HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
//        }
//    }
 // Add getAllUser API implementation
    @GetMapping("/getAllUsers")
    public ResponseEntity<?> getAllUsers(@RequestParam(required = false) Integer page,
                                         @RequestParam(required = false) Integer pageSize,
                                         @RequestParam(required = false) String role,
                                         @RequestParam(required = false) String searchKeyword,
                                         @RequestParam(required = false) String sortOrder) {
        try {
        	// Call the service method to retrieve all users
            List<User> users = userService.getAllUsers(role, searchKeyword, sortOrder, page, pageSize);
            
            // Return the response with the list of users
            return ResponseUtil.sendResponse("Users fetched successfully", users, HttpStatus.OK);
        } catch (Exception e) {
            // Handle exceptions and return an error response
            return ResponseUtil.sendError("Failed to fetch users", HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }


    // adduser API implementation
    @PostMapping("/addUser")
    public ResponseEntity<?> addUser(@RequestBody User user) {
        try {
            // Call the service method to add a user
            userService.addUser(user);
            // Return a success response
            return ResponseUtil.sendResponse("User added successfully", user, HttpStatus.OK);
        } catch (Exception e) {
            // Handle exceptions and return an error response
            return ResponseUtil.sendError("Failed to add user", HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }
}
