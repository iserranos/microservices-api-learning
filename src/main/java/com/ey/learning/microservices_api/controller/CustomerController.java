package com.ey.learning.microservices_api.controller;

import com.ey.learning.microservices_api.model.Customer;
import com.ey.learning.microservices_api.service.impl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.jaxrs.JaxRsLinkBuilder.linkTo;

@RestController
@RequestMapping(value = "/customer", produces = {"application/json"})
public class CustomerController {

    @Autowired
    private  CustomerServiceImpl customerServiceImpl;



    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable String id) {
        Customer customer = customerServiceImpl.getById(id);
        // TODO check customer != null
//        customer.add(linkTo(CustomerController.class).slash(customer.getCustomerId()).withSelfRel());
        return customer;
    }

    @PostMapping
    public Customer saveNewCustomer(@RequestBody Customer customer){
        return null;
    }
}