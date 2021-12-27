package com.example.customer.controllers;

import com.example.customer.clients.OfferClients;
import com.example.customer.exception.CustomerNotFoundException;
import com.example.customer.exception.PaidTypeLinkedToUserException;
import com.example.customer.exception.PaidTypeNotFoundException;
import com.example.customer.service.CustomerService;
import com.example.customer.service.PaidTypeService;
import com.example.customer.transfer.OfferDTO.OfferDTO;
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
        return "customers.admins";
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

    @GetMapping("/category")
    public String addCategoryPage(ModelMap model, Authentication authentication) {
        if (authentication == null) {
            return "redirect:/login";
        }
        model.addAttribute("categoriesFromServer", OfferClients.getCategory());
        return "new.category";
    }

    @PostMapping("/category")
    public String addCategory(ModelMap model, Authentication authentication, String name) {
        if (authentication == null) {
            return "redirect:/login";
        }
        OfferClients.addCategory(name);
        return "redirect:/admin/category";
    }

    @GetMapping("/characteristic")
    public String addCharacteristicPage(ModelMap model, Authentication authentication) {
        if (authentication == null) {
            return "redirect:/login";
        }
        model.addAttribute("characteristicsFromServer", OfferClients.getCharacteristic());
        return "new.characteristic";
    }

    @PostMapping("/characteristic")
    public String addCharacteristic(ModelMap model, Authentication authentication, String name, String description) {
        if (authentication == null) {
            return "redirect:/login";
        }
        OfferClients.addCharacteristic(name, description);
        return "redirect:/admin/characteristic";
    }

    @GetMapping("/offer")
    public String addOfferPage(ModelMap model, Authentication authentication) {
        if (authentication == null) {
            return "redirect:/login";
        }
        model.addAttribute("offersFromServer", OfferClients.getOffers());
        return "new.offer";
    }

    @PostMapping("/offer")
    public String addOffer(ModelMap model, Authentication authentication, OfferDTO offerDTO) {
        if (authentication == null) {
            return "redirect:/login";
        }
        OfferClients.addOffer(offerDTO);
        return "redirect:/admin/offer";
    }

    @GetMapping("/offer-update")
    public String offerUpdatePage(ModelMap model, Authentication authentication, Long id) {
        if (authentication == null) {
            return "redirect:/login";
        }
        model.addAttribute("offerFromServer", OfferClients.getOffer(id));
        model.addAttribute("paidTypesFromServer", paidTypeService.findAllPaidTypes());
        return "offer.update";
    }

    @PostMapping("/offer-update")
    public String offerUpdate(ModelMap model, Authentication authentication, OfferDTO offerDTO, Long id) {
        if (authentication == null) {
            return "redirect:/login";
        }
        OfferClients.updateOffer(offerDTO);
        return "redirect:/admin/offer";
    }

    @PostMapping("/offer-update/paid-type")
    public String addPaidTypeFromOffer(ModelMap model, Authentication authentication, Long paidTypeId, Long offerId) {
        if (authentication == null) {
            return "redirect:/login";
        }
        OfferClients.addPaidType(offerId, paidTypeId);
        model.addAttribute("offerFromServer", OfferClients.getOffer(offerId));
        return "redirect:/admin/offer-update?id=" + offerId;
    }
}
