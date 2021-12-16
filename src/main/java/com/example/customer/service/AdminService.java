package com.example.customer.service;

import com.example.customer.exception.CustomerNotFoundException;
import com.example.customer.models.Customer;
import com.example.customer.models.State;
import com.example.customer.repository.CustomerDao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AdminService {

    private final CustomerDao customersDao;

    public void BanCustomerById(Long id) throws CustomerNotFoundException {
        Customer customer = customersDao.findById(id).get();
        if ( customer == null) {
            throw new CustomerNotFoundException("Customer Not Found");
        }
        customer.setState(State.BANNED);
        customersDao.save(customer);
    }

    public void UnBanCustomerById(Long id) throws CustomerNotFoundException {
        Customer customer = customersDao.findById(id).get();
        if ( customer == null) {
            throw new CustomerNotFoundException("Customer Not Found");
        }
        customer.setState(State.ACTIVE);
        customersDao.save(customer);
    }
}
