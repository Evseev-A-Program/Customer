package com.example.customer.service;

import com.example.customer.exception.CustomerAlreadyExistException;
import com.example.customer.exception.CustomerNotFoundException;
import com.example.customer.models.Customer;
import com.example.customer.models.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.example.customer.repository.CustomerDao;

import java.util.Collections;


@Service
public class CustomerService implements UserDetailsService {

    @Autowired
    private CustomerDao customersDao;

    public Customer findCustomerById(Long id) throws CustomerNotFoundException {
        Customer customer = customersDao.findById(id).get();
        if ( customer == null) {
            throw new CustomerNotFoundException("Customer Not Found");
        }
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
        customer.deletePaidType();
        customersDao.deleteById(id);
    }

    public void saveCustomers(Customer customer) throws CustomerAlreadyExistException, CustomerNotFoundException {
        if (customer == null) {
            throw new CustomerNotFoundException("Customer Not Found");
        }

        Customer checkCustomer = customersDao.findByEmail(customer.getEmail());
        if(checkCustomer != null && !checkCustomer.getId().equals(customer.getId())) {
            throw new CustomerAlreadyExistException("This email is already in use");
        }
        checkCustomer = customersDao.findByPhoneNumber(customer.getPhoneNumber());
        if( checkCustomer != null && !checkCustomer.getId().equals(customer.getId())) {
            throw new CustomerAlreadyExistException("This phone number is already in use");
        }

        customer.setRoles(Collections.singleton(Role.builder().name("ROLE_USER").build()));
        customersDao.save(customer);
    }



    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Customer customer = customersDao.findByEmail(email);
        if ( customer == null) {
            throw new UsernameNotFoundException("Customer Not Found");
        }

        return customer;
    }
}
