package com.github.szsascha.servicediscovery.cityservice.controller;

import com.github.szsascha.servicediscovery.cityservice.model.City;
import com.github.szsascha.servicediscovery.cityservice.service.CityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class CityController {

    private final CityService cityService;

    @Value("${eureka.instance.instanceId}")
    private String instanceId;

    CityController(final CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/cities")
    ResponseEntity<List<City>> all() {
        log.info("Get all cities requested in instance {}", instanceId);
        return ResponseEntity.ok(cityService.findAll());
    }

    @GetMapping("/cities/{country}/{postalcode}")
    ResponseEntity<City> one(@PathVariable String country, @PathVariable String postalcode) {
        log.info("City with postalcode {}, {} requested in instance {}", postalcode, country, instanceId);
        final City city = cityService.findByCountryAndPostalcode(country, postalcode);

        if (city == null) {
            log.warn("City with postalcode {}, {} not found in instance {}", postalcode, country, instanceId);
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(city);
    }

}
