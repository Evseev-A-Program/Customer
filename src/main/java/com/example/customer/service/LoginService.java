package com.example.customer.service;

import com.example.customer.repository.CustomerDao;
import com.example.customer.repository.TokenDao;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LoginService {

    @Autowired
    private TokenDao tokenDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private CustomerDao customerDao;

//    public String getToken(LoginForm loginForm) {
//        Optional<Customer> userCandidate = customerDao.findByEmail(loginForm.getEmail());
//
//        if (userCandidate.isPresent()) {
//            Customer customer = userCandidate.get();
//
//            if (passwordEncoder.matches(loginForm.getPassword(), customer.getHashPassword())) {
//                return provider.generateToken(loginForm.getEmail());
//
//             }
//        } throw new IllegalArgumentException("Customer not found");
//    }
}
