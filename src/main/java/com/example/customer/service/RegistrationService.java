package com.example.customer.service;

import com.example.customer.exception.CustomerAlreadyExistException;
import com.example.customer.exception.CustomerNotFoundException;
import com.example.customer.models.Address;
import com.example.customer.models.Customer;
import com.example.customer.models.Role;
import com.example.customer.models.State;
import com.example.customer.repository.CustomerDao;
import com.example.customer.repository.RegistrationDao;
import com.example.customer.forms.UserForm;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService implements RegistrationDao {

    private final CustomerDao customerDao;

    private final PasswordEncoder passwordEncoder;


    public void reg(UserForm userForm) throws CustomerAlreadyExistException, CustomerNotFoundException {
        String hashPassword = passwordEncoder.encode(userForm.getPassword());
        if (!customerDao.findByEmail(userForm.getEmail()).isPresent() && !customerDao.findByPhoneNumber(userForm.getPhoneNumber()).isPresent()) {
            Customer customer = Customer.builder()
                    .hashPassword(hashPassword)
                    .email(userForm.getEmail())
                    .phoneNumber(userForm.getPhoneNumber())
                    .firstName(userForm.getFirstName())
                    .lastName(userForm.getLastName())
                    .role(Role.USER)
                    .state(State.ACTIVE)
                    .address(Address.builder()
                            .city(userForm.getCity())
                            .street(userForm.getStreet())
                            .country(userForm.getCountry()).build())
                    .build();

            customerDao.save(customer);
        } else throw new CustomerAlreadyExistException("Customer already exists");
    }
}
