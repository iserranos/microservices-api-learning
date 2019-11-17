package com.ey.learning.microservices_api;

import com.ey.learning.microservices_api.model.Customer;
import com.ey.learning.microservices_api.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.dao.DuplicateKeyException;

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
        /*try {

        }catch (DuplicateKeyException e){
            toString();
        }*/
            repository.save(new Customer("Guillermo", "Crespo", "EY"));
            repository.save(new Customer("Guillermo", "Crespo", "Google"));



    }
}
