package com.example.customer.controllers;

import com.example.customer.models.Address;
import com.example.customer.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/addresses")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping
    public ResponseEntity addAddress(@RequestBody Address address){
        try{
            addressService.saveAddresses(address);
            return ResponseEntity.ok("Address SAVE");
        } catch (Exception e){
            return ResponseEntity.badRequest().body("ERROR!!!");
        }
    }
}
