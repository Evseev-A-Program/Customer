package com.example.customer.controllers;

import com.example.customer.exception.CustomerNotFoundException;
import com.example.customer.exception.PaidTypeLinkedToUserException;
import com.example.customer.exception.PaidTypeNotFoundException;
import com.example.customer.security.details.UserDetailsImpl;
import com.example.customer.service.CustomerService;
import com.example.customer.service.PaidTypeService;
import com.example.customer.transfer.customerDTO.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import utils.CustomerFromAuthentication;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private PaidTypeService paidTypeService;


    @GetMapping("/")
    public String getAdminPage(ModelMap model, Authentication authentication) {
        if (authentication == null) {
            return "redirect:/login";
        }
        model.addAttribute("customer", CustomerFromAuthentication.getCustomer(authentication));
        return "admin";
    }


    @GetMapping("/customers")
    public String getCustomersPage(ModelMap model) {
        model.addAttribute("customersFromServer", customerService.findAllCustomers());
        return "customers";
    }

    @GetMapping("/paid-types")
    public String getPaidTypesPage(ModelMap model) {
        model.addAttribute("paidTypesFromServer", paidTypeService.findAllPaidTypes());
        return "paid.types.admins";
    }

    @PostMapping("/banned")
    public String CustomerBannedById(ModelMap model, Long id) throws CustomerNotFoundException {
        try {
            customerService.BanCustomerById(id);
        } catch (Exception e) {
            model.addAttribute("userNotFound", true);
        }
        return getCustomersPage(model);
    }

    @PostMapping("/unbanned")
    public String CustomerUnBannedById(ModelMap model, Long id) throws CustomerNotFoundException {
        try {
            customerService.UnBanCustomerById(id);
        } catch (Exception e) {
            model.addAttribute("userNotFound", true);
        }

        return getCustomersPage(model);
    }

    @PostMapping("/paid-types/delete")
    public String deletePaidType(Long id) throws PaidTypeLinkedToUserException, PaidTypeNotFoundException {
        paidTypeService.deletePaidTypeById(id);
        return "redirect:/admin/paid-types";
    }

    @PostMapping("/paid-types/active")
    public String activePaidType(Long id) throws PaidTypeLinkedToUserException, PaidTypeNotFoundException {
        paidTypeService.activePaidTypeById(id);
        return "redirect:/admin/paid-types";
    }
}
