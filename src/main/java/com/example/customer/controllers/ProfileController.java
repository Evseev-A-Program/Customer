package com.example.customer.controllers;


import com.example.customer.models.Role;
import com.example.customer.security.details.UserDetailsImpl;
import com.example.customer.transfer.customerDTO.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfileController {

    @Autowired
    private AdminController adminController;
    @Autowired
    private UserController userController;


    @GetMapping("/")
    public String getProfilePage(ModelMap modelMap, Authentication authentication) {
        if (authentication == null) {
            return "redirect:/login";
        }
        UserDetailsImpl details = (UserDetailsImpl) authentication.getPrincipal();
        CustomerDTO customer = CustomerDTO.from(details.getCustomer());
        if (customer.getRole().equals(Role.ADMIN)){
            modelMap.addAttribute("customer", customer);
            return adminController.getAdminPage(authentication);
        }
        modelMap.addAttribute("customer", customer);
            return userController.getUserPage(authentication);
    }


}
