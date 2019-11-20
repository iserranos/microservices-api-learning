package com.ey.learning.microservices_api.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Customer {
    @Id
    private String customerId;
    private String firstName;
    private String lastName;
    private String company;

    public Customer(String firstName, String lastName, String company) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
    }


    @Override
    public String toString() {
        return String.format(
                "Customer[id=%s, firstName='%s', lastName='%s']",
                customerId, firstName, lastName);
    }
}
