package com.example.customer.controllers;


import com.example.customer.models.Role;
import com.example.customer.security.details.UserDetailsImpl;
import com.example.customer.transfer.customerDTO.CustomerDTO;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfileController {



    @GetMapping("/")
    public String getProfilePage(Authentication authentication) {
        if (authentication == null) {
            return "redirect:/login";
        }

        UserDetailsImpl details = (UserDetailsImpl) authentication.getPrincipal();
        CustomerDTO customer = CustomerDTO.from(details.getCustomer());

        if (customer.getRole().equals(Role.ADMIN)){
            return "redirect:/admin/";
        }
            return "redirect:/user/";
    }


}
