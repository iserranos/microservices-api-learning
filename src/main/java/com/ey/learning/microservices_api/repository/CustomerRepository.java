package com.ey.learning.microservices_api.repository;

import com.ey.learning.microservices_api.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends MongoRepository<Customer, String> {

    Optional<Customer> findByCustomerId(String id);

    Customer findByFirstName(String firstName);

    List<Customer> findByLastName(String lastName);

}
