package com.example.customer.controllers;

import com.example.customer.models.Customer;
import com.example.customer.models.Role;
import com.example.customer.security.details.UserDetailsImpl;
import com.example.customer.service.CustomerService;
import com.example.customer.service.PaidTypeService;
import com.example.customer.transfer.customerDTO.CustomerDTO;
import com.example.customer.user.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private PaidTypeService paidTypeService;

    @GetMapping("/")
    public String getUserPage(Authentication authentication) {
        if (authentication == null) {
            return "redirect:/login";
        }

        return "user";
    }


    @GetMapping("/paid-types")
    public String PaidTypePage(ModelMap model, Authentication authentication) {
        if (authentication == null) {
            return "redirect:/login";
        }
        model.addAttribute("paidTypesFromServer", paidTypeService.findAllPaidTypes());
        return "paid.types.clients";
    }

    @GetMapping("/update")
    public String updateCustomerPage(ModelMap model, Authentication authentication) {
        if (authentication == null) {
            return "redirect:/login";
        }
        UserDetailsImpl details = (UserDetailsImpl) authentication.getPrincipal();
        CustomerDTO customer = CustomerDTO.from(details.getCustomer());
        model.addAttribute("customer", customer);
        return "customer.update";
    }

//    @PostMapping("/update")
//    public String updateCustomer(ModelMap model, Authentication authentication, UserForm userForm) {
//        if (authentication == null) {
//            return "redirect:/login";
//        }
//        UserDetailsImpl details = (UserDetailsImpl) authentication.getPrincipal();
//        CustomerDTO customer = CustomerDTO.from(details.getCustomer());
//        try {
//            customerService.saveCustomers();
//        }
//        return "customer.update";
//    }
}
