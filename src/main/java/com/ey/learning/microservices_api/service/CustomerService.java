package com.ey.learning.microservices_api.service;

import com.ey.learning.microservices_api.model.Customer;

import java.util.List;

public interface CustomerService {

    Customer getById(String id);

    List<Customer> getAll();

    Customer save(Customer customer);

    Customer update(Customer customer);

    void delete(String id);
}
