package com.ey.learning.microservices_api.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.hateoas.ResourceSupport;


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

    public Customer() {

    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%s, firstName='%s', lastName='%s']",
                customerId, firstName, lastName);
    }
}
