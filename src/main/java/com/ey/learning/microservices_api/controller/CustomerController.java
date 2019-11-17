package com.ey.learning.microservices_api.controller;

import com.ey.learning.microservices_api.model.Customer;
import com.ey.learning.microservices_api.service.impl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

//import static org.springframework.hateoas.jaxrs.JaxRsLinkBuilder.linkTo;

@RestController
@RequestMapping(value = "/customers", produces = {"application/json"},path = "/customers")
public class CustomerController {

    @Autowired
    private  CustomerServiceImpl customerServiceImpl;



    @JsonProperty
    @GetMapping(value = "/")
    public List<Customer> getCustomers() {
        List<Customer> customers =customerServiceImpl.getAll();
        linkTo(CustomerController.class).slash(customers).withSelfRel();
        return  customers;
    }

    @GetMapping(value = "/{id}")
    public Customer getCustomerById(@PathVariable("id") String id) {
        Customer customer = customerServiceImpl.getById(id);
        // TODO check customer != null

        //customer.add(linkTo(CustomerController.class).slash(customer.getCustomerId()).withSelfRel());
        return customer;
    }

    @GetMapping(value = "/{name}")
    public Customer getCustomerByFirstName(@PathVariable("name") String name) {
        Customer customer = customerServiceImpl.getCustomerFirstName(name);
        // TODO check customer != null

        // customer.add(linkTo(CustomerController.class).slash(customer.getCustomerId()).withSelfRel());
        return customer;
    }

    @PutMapping("/{id}")
    public Customer updateCustomer(@PathVariable String id) {

        return customerServiceImpl.updateCustomer(id,customerServiceImpl.getById(id));
    }

    @PostMapping
    public Customer saveNewCustomer(@RequestBody Customer customer){
        return customerServiceImpl.saveCustomer(customer);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable String id) {
        customerServiceImpl.deleteCustomerById(id);
    }

}