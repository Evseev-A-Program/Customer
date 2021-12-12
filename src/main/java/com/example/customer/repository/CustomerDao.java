package com.example.customer.repository;


import com.example.customer.models.Customer;

import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerDao extends CrudRepository<Customer, Long> {

    Optional<Customer> findByEmail(String email);

    Optional<Customer> findByPhoneNumber(String phoneNumber);

}
