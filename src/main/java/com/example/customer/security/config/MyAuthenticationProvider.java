//package com.example.customer.security.config;
//
//
//import com.example.customer.models.Customer;
//import com.example.customer.repository.CustomerDao;
//import com.example.customer.security.details.UserDetailsImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//
//import java.util.Collections;
//import java.util.Optional;
//
//@Component
//public class MyAuthenticationProvider implements AuthenticationProvider {
//
//    @Autowired
//    private CustomerDao dao;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    @Override
//    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//        String userName = authentication.getName();
//        String password = authentication.getCredentials().toString();
//        //получаем пользователя
//        Optional<Customer> customer = dao.findByEmail(userName);
//        //смотрим, найден ли пользователь в базе
//        if (!customer.isPresent()){
//            throw new BadCredentialsException("Unknown user " + userName);       }
//        if (!passwordEncoder.matches(password, customer.get().getHashPassword())) {
//            throw new BadCredentialsException("Bad password");
//        }
//        UserDetails principal = new UserDetailsImpl(customer.get());
//        return new UsernamePasswordAuthenticationToken(
//                principal, password, principal.getAuthorities());
//    }
//
//    @Override
//    public boolean supports(Class<?> authentication) {
//        return authentication.equals(UsernamePasswordAuthenticationToken.class);
//    }
//}