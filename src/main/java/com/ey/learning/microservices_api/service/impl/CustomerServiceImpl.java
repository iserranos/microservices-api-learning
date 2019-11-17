package com.ey.learning.microservices_api.service.impl;

import com.ey.learning.microservices_api.model.Customer;
import com.ey.learning.microservices_api.repository.CustomerRepository;
import com.ey.learning.microservices_api.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer getById(String id) {
        Optional<Customer> optionalCustomer = customerRepository.findByCustomerId(id);
        return optionalCustomer.orElse(null);
    }
    @Override
    public Customer getCustomerFirstName(String name) {
        return customerRepository.findByFirstName(name);
    }

    @Override
    public List<Customer> getAll() {

        List<Customer> allCustomers = new ArrayList<>();
        for (Customer customer : customerRepository.findAll()) {

            allCustomers.add(customer);
        }
        return allCustomers;

    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(String id, Customer customer) {
        customerRepository.deleteById(id);
        return customerRepository.save(customer);
    }

    @Override
    public void deleteCustomerById(String id) {
        customerRepository.deleteById(id);
    }
}
