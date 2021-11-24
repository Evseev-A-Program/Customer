package com.example.customer.service;

import com.example.customer.exception.CustomerAlreadyExistException;
import com.example.customer.exception.CustomerNotFoundException;
import com.example.customer.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.customer.repository.CustomerDao;


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

    public void deleteCustomersById(Long id) throws CustomerNotFoundException {
        Customer customer = customersDao.findById(id).get();
        if (customer == null) {
            throw new CustomerNotFoundException("Customer Not Found");
        }
        customer.deletePaidType();
        customersDao.deleteById(id);
    }

    public Customer saveCustomers(Customer customer) throws CustomerAlreadyExistException {
//        if(customersDao.findByEmail(customer.getEmail()) != null) {
//            throw new CustomerAlreadyExistException("This email is already in use");
//        }
//        if( customersDao.findByPhoneNumber(customer.getPhoneNumber()) != null) {
//            throw new CustomerAlreadyExistException("This phone number is already in use");
//        }
        return customersDao.save(customer);
    }


    public void updateCustomerById(Customer customer) throws CustomerNotFoundException, CustomerAlreadyExistException {
        if (customer == null) {
            throw new CustomerNotFoundException("Customer Not Found");
        }
//
//        if(customersDao.findByEmail(customer.getEmail()) != null) {
//            throw new CustomerAlreadyExistException("This email is already in use");
//        }
//        if(customersDao.findByPhoneNumber(customer.getPhoneNumber()) != null) {
//            throw new CustomerAlreadyExistException("This phone number is already in use");
//        }

        customersDao.save(customer);
    }

}
