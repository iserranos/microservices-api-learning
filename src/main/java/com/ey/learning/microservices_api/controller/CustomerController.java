package com.ey.learning.microservices_api.controller;

import com.ey.learning.microservices_api.model.Customer;
import com.ey.learning.microservices_api.service.impl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.MediaTypes;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping(value ="/api/v0/customers", produces = {"application/json"}, path = "/api/v0/customers")
public class CustomerController {

    @Autowired
    private   CustomerServiceImpl customerServiceImpl;


    @GetMapping
    public List<Customer> getCustomers() {
        List<Customer> customers =customerServiceImpl.getAll();

        return  customers;
    }



    @GetMapping(value = "/{id}", produces = MediaTypes.HAL_JSON_VALUE)
    public  Customer getCustomerById(@PathVariable("id") String id) {
        Customer customer = customerServiceImpl.getById(id);


        return customer;
    }




    @GetMapping(params = "name")
    public Customer getCustomerByFirstName(@RequestParam("name") String name) {
        Customer customer = customerServiceImpl.getCustomerFirstName(name);
        return customer;
    }

    @PutMapping("/{id}")
    public Customer updateCustomer(@PathVariable String id, @RequestBody Customer customer) {

        return customerServiceImpl.updateCustomer(id,customer);
    }

    @PostMapping
    public Customer saveNewCustomer(@RequestBody Customer customer){
        return customerServiceImpl.saveCustomer(customer);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomerById(@PathVariable String id) {
        customerServiceImpl.deleteCustomerById(id);
    }

    @DeleteMapping
    public void deleteCustomerByName(@RequestParam("name") String name) {
        customerServiceImpl.deleteCustomerByName(name);
    }

}