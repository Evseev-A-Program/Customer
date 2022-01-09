package com.example.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class CustomerApplication {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    public EmbeddedServletContainerCustomizer containerCustomizer() {
//        return container -> container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/error.ftl"));
//    }

    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class, args);
    }

}
