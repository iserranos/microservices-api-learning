package com.ey.learning.microservices_api.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.hateoas.ResourceSupport;

@EqualsAndHashCode(callSuper = true)
@Data
public class Customer extends ResourceSupport {

    @Id
    private String customerId;
    private String firstName;
    private String lastName;
    private String company;

}
