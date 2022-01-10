package com.example.customer.service;

import com.example.customer.forms.LoginForm;
import com.example.customer.forms.UserForm;
import com.example.customer.models.Customer;
import com.example.customer.models.Token;
import com.example.customer.repository.CustomerDao;
import com.example.customer.repository.TokenDao;
import com.example.customer.transfer.transfer.TokenDto;
import lombok.AllArgsConstructor;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.example.customer.transfer.transfer.TokenDto.from;

@Service
@AllArgsConstructor
public class LoginService {

    @Autowired
    private TokenDao tokenDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private CustomerDao customerDao;

    public TokenDto getToken(LoginForm loginForm) {
        Optional<Customer> userCandidate = customerDao.findByEmail(loginForm.getEmail());

        if (userCandidate.isPresent()) {
            Customer customer = userCandidate.get();

           // if (passwordEncoder.matches(loginForm.getPassword(), customer.getHashPassword())) {
                Token token = Token.builder()
                        .customer(customer)
                        .value(RandomStringUtils.random(10, true, true))
                        .build();

                tokenDao.save(token);
                 return from(token);
            // }
        } throw new IllegalArgumentException("Customer not found");
    }
}
