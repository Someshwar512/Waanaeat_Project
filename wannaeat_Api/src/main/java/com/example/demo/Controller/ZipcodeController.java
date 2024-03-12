// ZipcodeController.java
package com.example.demo.Controller;

import com.example.demo.Model.Zipcode;
import com.example.demo.Service.ZipcodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/zipcode")
public class ZipcodeController {

    private final ZipcodeService zipcodeService;

    @Autowired
    public ZipcodeController(ZipcodeService zipcodeService) {
        this.zipcodeService = zipcodeService;
    }

    @PostMapping("/addzipcode")
    public ResponseEntity<String> addZipcode(@RequestBody Zipcode zipcode) {
        try {
            String city = zipcode.getCity().getName();
            String state = zipcode.getCity().getState().getName();
            String country = zipcode.getCity().getState().getCountry().getName();
            
            zipcodeService.addZipcode(zipcode.getZipcode(), city, state, country);
            
            return ResponseEntity.ok("Zip code '" + zipcode.getZipcode() + "' added successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("Failed to add zip code: " + e.getMessage());
        }
    }
}
