package com.example.customer.security.details;

import com.example.customer.exception.CustomerNotFoundException;
import com.example.customer.models.Customer;
import com.example.customer.repository.CustomerDao;
import com.example.customer.security.details.UserDetailsImpl;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImple implements UserDetailsService {

    @Autowired
    private CustomerDao customerDao;

    @SneakyThrows
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Customer> user = customerDao.findByEmail(email);
        if (user.isPresent()) {
            return new UserDetailsImpl(user.get());
        } else throw new CustomerNotFoundException("Customer Not Found");
    }
}
