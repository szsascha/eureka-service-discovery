package com.github.szsascha.servicediscovery.cityservice.service;

import com.github.szsascha.servicediscovery.cityservice.model.City;

import java.util.List;

public interface CityService {

    City findByCountryAndPostalcode(String country, String postalcode);

    List<City> findAll();

}
