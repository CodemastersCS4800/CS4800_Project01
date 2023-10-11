package com.javaguides.springboot.service;

import com.javaguides.springboot.model.Customer;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class CustomerService {

    // getCustomers Method--------------------------
    public List<Customer> getCustomers() {
        return List.of(
                new Customer(
                        1L,
                        "Charlie Boi",
                        "charlie.boi@gmail.com"

                )
        );

    }
}
