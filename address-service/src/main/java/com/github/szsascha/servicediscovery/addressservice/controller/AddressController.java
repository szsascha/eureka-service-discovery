package com.github.szsascha.servicediscovery.addressservice.controller;

import com.github.szsascha.servicediscovery.addressservice.model.Address;
import com.github.szsascha.servicediscovery.addressservice.service.AddressService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class AddressController {

    private final AddressService addressService;

    @Value("${eureka.instance.instanceId}")
    private String instanceId;

    AddressController(final AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/addresses/{name}")
    ResponseEntity<Address> one(@PathVariable String name) {
        log.info("Address {} requested in instance {}", name, instanceId);
        final Address address = addressService.findByName(name);

        if (address == null) {
            log.warn("Address with name {} not found in instance {}", name, instanceId);
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(address);
    }

}
