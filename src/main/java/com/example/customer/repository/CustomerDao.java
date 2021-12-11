package com.example.customer.repository;


import com.example.customer.models.Address;
import com.example.customer.models.Customer;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDao extends CrudRepository<Customer, Long> {

    Customer findByEmail(String email);

    Customer findByPhoneNumber(String phoneNumber);

}
