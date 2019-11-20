package com.ey.learning.microservices_api.service;

import com.ey.learning.microservices_api.model.Customer;

import java.util.List;

public interface CustomerService {

    Customer getById(String id);

    Customer getCustomerFirstName(String name);

    List<Customer> getAll();

    Customer saveCustomer(Customer customer);

    Customer updateCustomer(String id, Customer customer);

    void deleteCustomerById(String id);

    void deleteCustomerByName(String name);
}
