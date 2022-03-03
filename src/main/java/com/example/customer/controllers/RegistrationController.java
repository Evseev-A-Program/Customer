package com.example.customer.controllers;

import com.example.customer.exception.CustomerAlreadyExistException;
import com.example.customer.exception.CustomerNotFoundException;
import com.example.customer.service.RegistrationService;
import com.example.customer.forms.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class  RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @GetMapping("/registration")
    public String RegistrationPage(UserForm userForm) {
        return "registration";
    }

    @PostMapping("/registration")
    public String Registration(UserForm userForm, ModelMap model) throws CustomerAlreadyExistException, CustomerNotFoundException {
        try {
            registrationService.reg(userForm);
        } catch (CustomerAlreadyExistException e) {
            model.addAttribute("error", true);
            return "registration";
        }

        return "redirect:/login";
    }
}
