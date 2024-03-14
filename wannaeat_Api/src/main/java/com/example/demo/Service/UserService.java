package com.example.demo.Service;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Constants.Database_Table;
import com.example.demo.Constants.Database_Table.DeletedStatus;
import com.example.demo.Constants.Database_Table.Status;
import com.example.demo.Model.User;
import com.example.demo.Model.UserAddress;
import com.example.demo.Repositroy.UserAddressRepository;
import com.example.demo.Repositroy.UserRepository;
import com.example.demo.Util.Paginator;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private UserAddressRepository addressRepository;
    @PersistenceContext
    private EntityManager entityManager;

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
    public List<User> getAllUsers(String role, String searchKeyword, String sortOrder, int page, int pageSize) {
        try {
            String queryStr = "SELECT u FROM User u WHERE u.role = :role " +
                              "AND u.isDeleted = :isDeleted " +
                              "AND u.status = :status " +
                              "AND (u.email LIKE :searchKeyword OR u.phone LIKE :searchKeyword " +
                              "OR u.status LIKE :searchKeyword OR u.createdOn LIKE :searchKeyword) " +
                              "ORDER BY u.id " + sortOrder;
            
            Query query = (Query) entityManager.createQuery(queryStr);
            query.setParameter("role", role);
            query.setParameter("isDeleted", DeletedStatus.NOT_DELETED);
            query.setParameter("status", Status.ACTIVE);
            query.setParameter("searchKeyword", "%" + searchKeyword + "%");

            return (List<User>) Paginator.paginate(query, page, pageSize).getResultList();
        } catch (Exception e) {
            // Handle exceptions appropriately
            e.printStackTrace(); // or log the error
            return null;
        }
    }
   

   
    
}
