package com.example.customer.repository;

import com.example.customer.exception.CustomerAlreadyExistException;
import com.example.customer.exception.CustomerNotFoundException;
import com.example.customer.user.UserForm;

public interface RegistrationDao {

    void reg(UserForm userForm) throws CustomerAlreadyExistException, CustomerNotFoundException;
}
