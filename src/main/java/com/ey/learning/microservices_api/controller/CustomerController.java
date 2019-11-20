package com.ey.learning.microservices_api.controller;

import com.ey.learning.microservices_api.model.Customer;
import com.ey.learning.microservices_api.service.impl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/api/v0/customers", produces = {"application/json"}, path = "/api/v0/customers")
public class CustomerController {

    private final CustomerServiceImpl customerServiceImpl;

    @Autowired
    public CustomerController(CustomerServiceImpl customerServiceImpl) {
        this.customerServiceImpl = customerServiceImpl;
    }


    @GetMapping
    public List<Customer> getCustomers() {
        return customerServiceImpl.getAll();
    }


    @GetMapping(value = "/{id}")
    public Customer getCustomerById(@PathVariable("id") String id) {
        return customerServiceImpl.getById(id);
    }


    @GetMapping(params = "name")
    public Customer getCustomerByFirstName(@RequestParam("name") String name) {
        return customerServiceImpl.getCustomerFirstName(name);
    }

    @PutMapping("/{id}")
    public Customer updateCustomer(@PathVariable String id, @RequestBody Customer customer) {
        return customerServiceImpl.updateCustomer(id, customer);
    }

    @PostMapping
    public Customer saveNewCustomer(@RequestBody Customer customer) {
        return customerServiceImpl.saveCustomer(customer);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomerById(@PathVariable String id) {
        customerServiceImpl.deleteCustomerById(id);
    }

    @DeleteMapping(params = "name")
    public void deleteCustomerByName(@RequestParam("name") String name) {
        customerServiceImpl.deleteCustomerByName(name);
    }

}