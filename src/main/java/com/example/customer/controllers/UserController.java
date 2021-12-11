package com.example.customer.controllers;

import com.example.customer.exception.CustomerAlreadyExistException;
import com.example.customer.exception.CustomerNotFoundException;
import com.example.customer.models.Customer;
import com.example.customer.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@RestController
@AllArgsConstructor
public class UserController {

    private final CustomerService customerService;

//    @GetMapping("/")
//    public String customer(Map<String, Object> model) {
//        return "customer";
//    }
//
    @GetMapping("/registration")
    public ModelAndView registration(Map<String, Object> model) {
        return new ModelAndView( "registration");
    }

    //
    @GetMapping("/main")
    public ModelAndView main(Map<String, Object> model) {
        return new ModelAndView( "main");
    }


    @PostMapping("/registration")
    public ModelAndView addCustomer(@ModelAttribute("userForm") Customer userForm, BindingResult bindingResult, Model model) throws CustomerAlreadyExistException, CustomerNotFoundException {

        customerService.saveCustomers(userForm);


        return new ModelAndView( "main");
    }
}
