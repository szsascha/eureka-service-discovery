package com.github.szsascha.servicediscovery.addressservice.service;

import com.github.szsascha.servicediscovery.addressservice.model.Address;

public interface AddressService {

    Address findByName(String name);

}
