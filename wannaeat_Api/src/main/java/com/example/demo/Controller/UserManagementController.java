package com.example.demo.Controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Constants.Database_Table.Roles;
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
 @GetMapping("/getAllUsers")
    public ResponseEntity<?> getAllUsers(@RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer pageSize,
            @RequestParam(required = false) String role,
            @RequestParam(required = false) String searchKeyword,
            @RequestParam(required = false) String sortOrder) {
try {
Roles enumRole = null;
if (role != null && !role.isEmpty()) {
// Check if the provided role string is valid
if (Arrays.stream(Roles.values()).anyMatch(r -> r.name().equalsIgnoreCase(role))) {
// Convert the role string to enum value
enumRole = Roles.valueOf(role.toUpperCase());
} else {
// If the role string is not valid, return a bad request response
return ResponseUtil.sendError("Invalid role provided", HttpStatus.BAD_REQUEST, "Invalid role: " + role);
}
}
// Call the service method to retrieve all users
List<User> users = userService.getAllUsers(enumRole, searchKeyword, sortOrder, page, pageSize);
// Return the response with the list of users
return ResponseUtil.sendResponse("Users fetched successfully", users, HttpStatus.OK);
} catch (Exception e) {
// Handle other exceptions and return an error response
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
