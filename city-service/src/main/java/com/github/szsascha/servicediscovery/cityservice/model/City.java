package com.github.szsascha.servicediscovery.cityservice.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class City {

    private List<String> postalcodes;

    private String name;

    private String country;

}
