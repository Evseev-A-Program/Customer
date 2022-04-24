package com.example.customer.controllers;

import com.example.customer.clients.OfferClients;
import com.example.customer.exception.CustomerNotFoundException;
import com.example.customer.exception.PaidTypeLinkedToUserException;
import com.example.customer.exception.PaidTypeNotFoundException;
import com.example.customer.forms.OfferForm;
import com.example.customer.service.CustomerService;
import com.example.customer.service.PaidTypeService;
import com.example.customer.transfer.transfer.OfferDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
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

    @GetMapping("/users")
    public String getCustomersPage(ModelMap model) {
       // model.addAttribute("customersFromServer", customerService.findAllCustomers());
        return "users.admins";
    }
    @GetMapping("/users/get")
    public String getCustomers(ModelMap model, String search) {
        model.addAttribute("customersFromServer", customerService.findCustomersByFistNameOfLastName(search));
        model.addAttribute("search", search);
        return "users.admins";
    }

    @GetMapping("/paid-types")
    public String getPaidTypesPage(ModelMap model) {
        model.addAttribute("paidTypesFromServer", paidTypeService.findAllPaidTypes());
        return "paid.types.admins";
    }

    @PostMapping("/get/banned")
    public String CustomerBannedById(ModelMap model, Long id, String search) throws CustomerNotFoundException {
            customerService.BanCustomerById(id);
        model.addAttribute("customersFromServer", customerService.findCustomersByFistNameOfLastName(search));
        model.addAttribute("search", search);
        return "users.admins";
    }

    @PostMapping("/get/unbanned")
    public String CustomerUnBannedById(ModelMap model, Long id, String search) throws CustomerNotFoundException {
            customerService.UnBanCustomerById(id);
        model.addAttribute("customersFromServer", customerService.findCustomersByFistNameOfLastName(search));
        model.addAttribute("search", search);
        return "users.admins";
    }

    @PostMapping("/paid-types/banned")
    public String deletePaidType(Long id) throws PaidTypeLinkedToUserException, PaidTypeNotFoundException {
        paidTypeService.deletePaidTypeById(id);
        return "redirect:/admin/paid-types";
    }

    @PostMapping("/paid-types/unbanned")
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
        return "category.admins";
    }

    @PostMapping("/category/delete")
    public String deleteCategoryById(Long id) throws PaidTypeLinkedToUserException, PaidTypeNotFoundException {
        OfferClients.delCategory(id);
        return "redirect:/admin/category";
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

    @GetMapping("/offers")
    public String addOfferPage(ModelMap model, Authentication authentication) {
        if (authentication == null) {
            return "redirect:/login";
        }
        model.addAttribute("categoriesFromServer", OfferClients.getCategory());
      //  model.addAttribute("offersFromServer", OfferClients.getOffers());
        return "offers.admins";
    }

    @PostMapping("/offers")
    public String addOffer(ModelMap model, Authentication authentication, OfferForm offerForm) throws JsonProcessingException {
        if (authentication == null) {
            return "redirect:/login";
        }
        OfferClients.addOffer(offerForm);
//        OfferClients.addCharacteristicFromOffer(offerForm.getId(),
//                offerForm.getCharacteristicName(),
//                offerForm.getCharacteristicDescription());
        return "redirect:/admin/offers";
    }

    @GetMapping("/offer-update")
    public String offerUpdatePage(ModelMap model, Authentication authentication, Long id) {
        if (authentication == null) {
            return "redirect:/login";
        }
        model.addAttribute("offerFromServer", OfferClients.getOffer(id));
        model.addAttribute("paidTypesFromServer", paidTypeService.findAllPaidTypes());
        model.addAttribute("categoriesFromServer", OfferClients.getCategory());
        model.addAttribute("characteristicsFromServer", OfferClients.getCharacteristic());
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


}
