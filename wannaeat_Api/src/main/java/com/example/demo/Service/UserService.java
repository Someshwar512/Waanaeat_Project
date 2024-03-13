package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Constants.Database_Table.Status;
import com.example.demo.Model.User;
import com.example.demo.Model.UserAddress;
import com.example.demo.Repositroy.UserAddressRepository;
import com.example.demo.Repositroy.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private UserAddressRepository addressRepository;

    public void addUser(User user) {
        user.setStatus(Status.ACTIVE); // Set default status to ACTIVE
        User savedUser = userRepository.save(user); // Save the user

        // Create a new UserAddress object
        UserAddress address = new UserAddress();
        address.setUser(savedUser); // Set the user for the address
//        address.setAddressLine1(user.getAddressLine1());
//        address.setAddressLine2(user.getAddressLine2());
//        address.setZipcodeId(user.getZipcodeId()); // Set the zipcode_id

        // Save the address
        addressRepository.save(address);
    }

    // You can add additional methods as needed
}
