package com.example.customer.controllers;

import com.example.customer.exception.CustomerNotFoundException;
import com.example.customer.exception.PaidTypeLinkedToUserException;
import com.example.customer.exception.PaidTypeNotFoundException;
import com.example.customer.service.CustomerService;
import com.example.customer.service.PaidTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private PaidTypeService paidTypeService;


    @GetMapping("/")
    public String getAdminPage(Authentication authentication) {
        if (authentication == null) {
            return "redirect:/login";
        }

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

    @GetMapping("/paid-types/delete")
    public String deletePaidType(ModelMap model, Long id) throws PaidTypeLinkedToUserException, PaidTypeNotFoundException {
            paidTypeService.deletePaidTypeById(id);
            return getPaidTypesPage(model);
    }
}
