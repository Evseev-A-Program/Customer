package com.example.customer.repository;


import com.example.customer.models.Customer;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerDao extends CrudRepository<Customer, Long> {

    Optional<Customer> findByEmail(String email);

    Optional<Customer> findByPhoneNumber(String phoneNumber);

    @Query(value = "select b from Customer b where " +
            "b.firstName like concat('%', :search, '%') " +
            "or b.lastName like concat('%', :search, '%') ")
    Iterable<Customer> findByFirstNameOrLastName(String search);

}
