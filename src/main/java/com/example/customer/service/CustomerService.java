package com.example.customer.service;

import com.example.customer.exception.CustomerAlreadyExistException;
import com.example.customer.exception.CustomerNotFoundException;
import com.example.customer.models.Customer;
import com.example.customer.models.Role;
import com.example.customer.models.State;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.example.customer.repository.CustomerDao;

import java.util.Collections;


@Service
@AllArgsConstructor
public class CustomerService{

    private final CustomerDao customersDao;

    public Customer findCustomerById(Long id) throws CustomerNotFoundException {
        Customer customer = customersDao.findById(id)
                .orElseThrow(()
                        -> new CustomerNotFoundException("Customer Not Found"));
        return customer;
    }

    public Iterable<Customer> findAllCustomers(){
        return  customersDao.findAll();
    }

    public void deleteCustomersById(Long id) throws CustomerNotFoundException {
        Customer customer = customersDao.findById(id).get();
        if (customer == null) {
            throw new CustomerNotFoundException("Customer Not Found");
        }
        customersDao.deleteById(id);
    }

    public void BanCustomerById(Long id){
        Customer customer = customersDao.findById(id).get();
        customer.setState(State.BANNED);
        customersDao.save(customer);
    }

    public void UnBanCustomerById(Long id){
        Customer customer = customersDao.findById(id).get();
        customer.setState(State.ACTIVE);
        customersDao.save(customer);
    }

    public void saveCustomers(Customer customer) throws CustomerAlreadyExistException, CustomerNotFoundException {
        if (customer == null) {
            throw new CustomerNotFoundException("Customer Not Found");
        }

    //    if (!customersDao.findByEmail(customer.getEmail()).isPresent() && !customersDao.findByPhoneNumber(customer.getPhoneNumber()).isPresent()) {
            customersDao.save(customer);
     //   } else throw new CustomerAlreadyExistException("Customer already exists");
    }




}
