package com.example.customer.controllers;

import com.example.customer.exception.CustomerAlreadyExistException;
import com.example.customer.exception.CustomerNotFoundException;
import com.example.customer.service.PaidTypeService;
import com.example.customer.service.RegistrationService;
import com.example.customer.user.UserForm;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @GetMapping("/registration")
    public String RegistrationPage(UserForm userForm) {
        return "registration";
    }

    @PostMapping("/registration")
    public String Registration(UserForm userForm) throws CustomerAlreadyExistException, CustomerNotFoundException {
        registrationService.reg(userForm);
        return "redirect:/login";
    }
}
