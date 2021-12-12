package com.github.szsascha.servicediscovery.cityservice.service;

import com.github.szsascha.servicediscovery.cityservice.model.City;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    private List<City> cities = new ArrayList<>();

    CityServiceImpl() {
        cities.add(
                City.builder()
                        .name("Bonn")
                        .postalcodes(List.of("53123", "53111", "53127", "53177"))
                        .country("Germany")
                        .build()
        );
        cities.add(
                City.builder()
                        .name("London")
                        .postalcodes(List.of("EC1A 1AA", "E1 7BH", "E1 7BT", "EC1A 2AL"))
                        .country("United Kingdom")
                        .build()
        );
    }

    @Override
    public City findByCountryAndPostalcode(String country, String postalcode) {
        return cities.stream()
                .filter(
                        city -> city.getCountry().equalsIgnoreCase(country)
                                && city.getPostalcodes().stream().anyMatch(p -> p.equalsIgnoreCase(postalcode))
                ).findAny().orElse(null);
    }

    @Override
    public List<City> findAll() {
        return cities;
    }
}
