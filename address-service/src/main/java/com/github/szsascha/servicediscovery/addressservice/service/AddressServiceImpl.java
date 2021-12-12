package com.github.szsascha.servicediscovery.addressservice.service;

import com.github.szsascha.servicediscovery.addressservice.model.Address;
import com.github.szsascha.servicediscovery.addressservice.model.City;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    private final List<Address> addresses = new ArrayList<>();

    private final CityService cityService;

    AddressServiceImpl(final CityService cityService) {
        this.cityService = cityService;

        addresses.add(
                Address.builder()
                        .name("Muster")
                        .street("Mustergasse")
                        .housenumber("42")
                        .postalcode("53123")
                        .country("Germany")
                        .build()
        );
        addresses.add(
                Address.builder()
                        .name("Sample")
                        .street("Samplestreet")
                        .housenumber("862")
                        .postalcode("EC1A 1AA")
                        .country("United Kingdom")
                        .build()
        );
    }

    @Override
    public Address findByName(String name) {
        return determineCityName(
                addresses.stream()
                    .filter(
                        address -> address.getName().equals(name)
                    )
                    .findAny()
                    .orElse(null)
        );
    }

    private Address determineCityName(Address address) {
        if (address == null) {
            return null;
        }

        final City city = cityService.findByCountryAndPostalcode(address.getCountry(), address.getPostalcode());
        address.setCity(city.getName());

        return address;
    }
}
