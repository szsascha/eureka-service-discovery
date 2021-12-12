package com.github.szsascha.servicediscovery.addressservice.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Address {

    private String name;

    private String street;

    private String housenumber;

    private String postalcode;

    private String city;

    private String country;

}
