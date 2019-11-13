package com.ey.learning.microservices_api.service.impl;

import com.ey.learning.microservices_api.model.Customer;
import com.ey.learning.microservices_api.repository.CustomerRepository;
import com.ey.learning.microservices_api.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<Customer> getAll() {
        return null;
    }

    @Override
    public Customer save(Customer customer) {
        return null;
    }

    @Override
    public Customer update(Customer customer) {
        return null;
    }

    @Override
    public void delete(String id) {

    }
}
