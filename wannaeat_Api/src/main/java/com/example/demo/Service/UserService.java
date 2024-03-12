package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Constants.Database_Table.Status;
import com.example.demo.Model.User;
import com.example.demo.Repositroy.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void addUser(User user) {
    	  user.setStatus(Status.ACTIVE); // Set default status in ACTIVE
        userRepository.save(user);
    }


	public User findByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}


}
