package com.example.customer.controllers;

import com.example.customer.exception.CustomerNotFoundException;
import com.example.customer.security.details.UserDetailsImpl;
import com.example.customer.service.AdminService;
import com.example.customer.service.CustomerService;
import com.example.customer.transfer.customerDTO.CustomerDTO;
import com.example.customer.user.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminController {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private AdminService adminService;

    @GetMapping("/customers")
    public String getCustomersPage(ModelMap model) {
        model.addAttribute("customersFromServer", customerService.findAllCustomers());
        return "customers";
    }

    @PostMapping("/banned")
    public String CustomerBannedById(Long id) throws CustomerNotFoundException {
            adminService.BanCustomerById(id);
            return "redirect:/customers";
    }

    @PostMapping("/unbanned")
    public String CustomerUnBannedById(Long id) throws CustomerNotFoundException {
        adminService.UnBanCustomerById(id);
        return "redirect:/customers";
    }
}
