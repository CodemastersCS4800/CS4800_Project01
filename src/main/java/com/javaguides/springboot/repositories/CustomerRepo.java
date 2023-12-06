package com.javaguides.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.javaguides.springboot.domains.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer>{
}
