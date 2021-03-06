package com.example.customer.controllers;

import com.example.customer.clients.OrderClients;
import com.example.customer.exception.CustomerAlreadyExistException;
import com.example.customer.exception.CustomerNotFoundException;
import com.example.customer.models.Address;
import com.example.customer.models.Customer;
import com.example.customer.security.details.UserDetailsImpl;
import com.example.customer.service.CustomerService;
import com.example.customer.service.PaidTypeService;
import com.example.customer.transfer.customerDTO.CustomerDTO;
import com.example.customer.forms.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import utils.CustomerFromAuthentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private PaidTypeService paidTypeService;

    @GetMapping("/")
    public String getUserPage(HttpServletResponse response, HttpServletRequest request, ModelMap model, Authentication authentication) throws CustomerNotFoundException {
        if (authentication == null) {
            return "redirect:/login";
        }
        UserDetailsImpl details = (UserDetailsImpl) authentication.getPrincipal();
        model.addAttribute("customer", CustomerDTO.from(details.getCustomer()));
        model.addAttribute("paidTypesClients", paidTypeService.findPaidTypeByIdCustomer(details.getCustomer().getId()));

        return "user";
    }


    @GetMapping("/paid-types")
    public String paidTypePage(ModelMap model, Authentication authentication) throws CustomerNotFoundException {
        if (authentication == null) {
            return "redirect:/login";
        }
        UserDetailsImpl details = (UserDetailsImpl) authentication.getPrincipal();
        model.addAttribute("paidTypesClients", paidTypeService.findPaidTypeByIdCustomer(details.getCustomer().getId()));
        model.addAttribute("paidTypesFromServer", paidTypeService.findAllPaidTypesForClients());
        return "paid.types";
    }

    @PostMapping("/paid-types/add")
    public String addPaidType(Authentication authentication, String name) {
        if (authentication == null) {
            return "redirect:/login";
        }
        UserDetailsImpl details = (UserDetailsImpl) authentication.getPrincipal();
        paidTypeService.savePaidType(name, details.getCustomer().getId());

        return "redirect:/user/paid-types";
    }

    @PostMapping("/paid-types/del")
    public String deletePaidType(Authentication authentication, String name) {
        if (authentication == null) {
            return "redirect:/login";
        }
        UserDetailsImpl details = (UserDetailsImpl) authentication.getPrincipal();
        paidTypeService.deletePaidType(name, details.getCustomer().getId());

        return "redirect:/user/paid-types";
    }

    @GetMapping("/update")
    public String updateCustomerPage(ModelMap model, Authentication authentication) {
        if (authentication == null) {
            return "redirect:/login";
        }
        model.addAttribute("customer", CustomerFromAuthentication.getCustomer(authentication));
        return "customer.update";
    }

    @PostMapping("/update")
    public String updateCustomer(Authentication authentication, UserForm userForm) throws CustomerAlreadyExistException, CustomerNotFoundException {
        if (authentication == null) {
            return "redirect:/login";
        }
        UserDetailsImpl details = (UserDetailsImpl) authentication.getPrincipal();
        Customer customer = details.getCustomer();
        customer.setPhoneNumber(userForm.getPhoneNumber());
        customer.setFirstName(userForm.getFirstName());
        customer.setLastName(userForm.getLastName());
        Address address = customer.getAddress();
        address.setCity(userForm.getCity());
        address.setStreet(userForm.getStreet());
        address.setCountry(userForm.getCountry());
        customerService.saveCustomers(customer);
        return "redirect:/";
    }

    @GetMapping("/cart")
    public String getCart(ModelMap model, Authentication authentication) {
        if (authentication == null) {
            return "redirect:/login";
        }
        UserDetailsImpl details = (UserDetailsImpl) authentication.getPrincipal();
        model.addAttribute("orders", OrderClients.getOrderByIdCustomer(details.getCustomer().getId()));
        return "cart";
    }

    @PostMapping("/cart/buy")
    public String buy(ModelMap model, Authentication authentication) {
        if (authentication == null) {
            return "redirect:/login";
        }
        UserDetailsImpl details = (UserDetailsImpl) authentication.getPrincipal();
        OrderClients.buyOrder(details.getCustomer().getId());
        return "redirect:/user/cart";
    }
}
