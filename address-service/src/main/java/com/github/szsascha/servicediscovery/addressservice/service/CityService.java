package com.github.szsascha.servicediscovery.addressservice.service;

import com.github.szsascha.servicediscovery.addressservice.model.City;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("city-service")
public interface CityService {

    @GetMapping("/cities/{country}/{postalcode}")
    City findByCountryAndPostalcode(@PathVariable String country, @PathVariable String postalcode);

}
