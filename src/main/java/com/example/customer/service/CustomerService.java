package com.example.customer.service;

import com.example.customer.exception.CustomerAlreadyExistException;
import com.example.customer.exception.CustomerNotFoundException;
import com.example.customer.models.Address;
import com.example.customer.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.customer.repository.CustomerDao;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class CustomerService {

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

    public void deleteCustomersById(Long id){
        customersDao.deleteById(id);
    }

    public void deleteCustomersAll(){
        customersDao.deleteAll();
    }

    public Customer saveCustomers(Customer customer) throws CustomerAlreadyExistException {
        if(customersDao.findByEmail(customer.getEmail()) != null) {
            throw new CustomerAlreadyExistException("There is already such an email");
        }
        if( customersDao.findByPhoneNumber(customer.getPhoneNumber()) != null) {
            throw new CustomerAlreadyExistException("There is already such an phone number");
        }
        return customersDao.save(customer);
    }



}
