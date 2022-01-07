package com.example.customer.controllers;

import com.example.customer.clients.OfferClients;
import com.example.customer.security.details.UserDetailsImpl;
import com.example.customer.transfer.customerDTO.CustomerDTO;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/store")
public class StoreController {

    @GetMapping("/")
    public String getStorePage(ModelMap model, Authentication authentication) {
        if (authentication == null) {
            return "redirect:/login";
        }
        model.addAttribute("offersFromServer", OfferClients.getOffersNotNull());
        return "store";
    }

    @PostMapping("/")
    public String addToCart(ModelMap model, Authentication authentication, Long id) {
        if (authentication == null) {
            return "redirect:/login";
        }

        return "redirect:/user";
    }

}
