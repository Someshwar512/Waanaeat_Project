// ZipcodeService.java
package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.City;
import com.example.demo.Model.Country;
import com.example.demo.Model.State;
import com.example.demo.Model.Zipcode;
import com.example.demo.Repositroy.CityRepository;
import com.example.demo.Repositroy.CountryRepository;
import com.example.demo.Repositroy.StateRepository;
import com.example.demo.Repositroy.ZipcodeRepository;

@Service
public class ZipcodeService {

    @Autowired
    private ZipcodeRepository zipcodeRepository;

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private StateRepository stateRepository;

    @Autowired
    private CountryRepository countryRepository;

    public void addZipcode(String zipcode, String cityName, String stateName, String countryName) {
        // Check if the zip code already exists
        if (zipcodeRepository.findByZipcode(zipcode) != null) {
            throw new RuntimeException("Zip code already exists");
        }

        City city = cityRepository.findByName(cityName);
        if (city == null) {
            State state = stateRepository.findByName(stateName);
            if (state == null) {
                Country country = countryRepository.findByName(countryName);
                if (country == null) {
                    country = new Country();
                    country.setName(countryName);
                    country = countryRepository.save(country);
                }
                state = new State();
                state.setName(stateName);
                state.setCountry(country);
                state = stateRepository.save(state);
            }
            city = new City();
            city.setName(cityName);
            city.setState(state);
            city = cityRepository.save(city);
        }

        Zipcode newZipcode = new Zipcode();
        newZipcode.setZipcode(zipcode);
        newZipcode.setCity(city);
        zipcodeRepository.save(newZipcode);
    }

}
