package com.ey.learning.microservices_api;

import com.ey.learning.microservices_api.model.Customer;
import com.ey.learning.microservices_api.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class MicroServiceAPI implements CommandLineRunner {


    @Autowired
    private CustomerRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(MicroServiceAPI.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        repository.deleteAll();

        repository.save(new Customer("Juan", "Prieto", "EY"));
        repository.save(new Customer("Paco", "Pérez", "Bankintor"));
        repository.save(new Customer("Peter", "Romanov", "BBVO"));
        repository.save(new Customer("Jordi", "Salas", "Vadofone"));


    }
}
