package com.example.customer.controllers;


import com.example.customer.security.details.UserDetailsImpl;
import com.example.customer.service.PaidTypeService;
import com.example.customer.transfer.customerDTO.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfileController {

    @Autowired
    private PaidTypeService paidTypeService;


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

    @GetMapping("/paid-type-clients")
    public String addPaidType(ModelMap model, Authentication authentication) {
        if (authentication == null) {
            return "redirect:/login";
        }
        model.addAttribute("paidTypesFromServer", paidTypeService.findAllPaidTypes());
        return "paid.types.clients";
    }
}
