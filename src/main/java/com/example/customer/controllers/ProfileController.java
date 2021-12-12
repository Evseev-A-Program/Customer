package com.example.customer.controllers;


import com.example.customer.exception.CustomerNotFoundException;
import com.example.customer.security.details.UserDetailsImpl;
import com.example.customer.transfer.customerDTO.CustomerDTO;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfileController {

    @GetMapping("/")
    public String getProfilePage(ModelMap modelMap, Authentication authentication) {
        if (authentication == null) {
            return "redirect:/login";
        }
        UserDetailsImpl details = (UserDetailsImpl) authentication.getPrincipal();
        CustomerDTO customer = CustomerDTO.from(details.getCustomer());
        modelMap.addAttribute("customer", customer);
        return "profile";
    }
}
