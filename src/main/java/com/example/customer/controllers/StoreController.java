package com.example.customer.controllers;

import com.example.customer.clients.OfferClients;
import com.example.customer.clients.OrderClients;
import com.example.customer.exception.CustomerNotFoundException;
import com.example.customer.security.details.UserDetailsImpl;
import com.example.customer.service.PaidTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/store")
public class StoreController {

    @Autowired
    private PaidTypeService paidTypeService;

    @GetMapping("/")
    public String getStorePage(ModelMap model, Authentication authentication) throws CustomerNotFoundException {
        if (authentication != null) {
            UserDetailsImpl details = (UserDetailsImpl) authentication.getPrincipal();
            model.addAttribute("paidTypesClients", paidTypeService.findPaidTypeByIdCustomer(details.getCustomer().getId()));
        }
        else {
            model.addAttribute("authentication", false);
        }

         model.addAttribute("offersFromServer", OfferClients.getOffersNotNull());

        return "store";
    }

    @PostMapping("/add")
    public String addToCart(ModelMap model, Authentication authentication, Long offerId) {
        if (authentication == null) {
            return "redirect:/login";
        }
        UserDetailsImpl details = (UserDetailsImpl) authentication.getPrincipal();
        OrderClients.addOrder(details.getCustomer().getId(), offerId);
        return "redirect:/store/";
    }




}
