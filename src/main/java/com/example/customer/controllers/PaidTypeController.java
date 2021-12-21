package com.example.customer.controllers;

import com.example.customer.exception.*;
import com.example.customer.models.Customer;
import com.example.customer.models.PaidType;
import com.example.customer.service.PaidTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/paid-type")
public class PaidTypeController {

    @Autowired
    private PaidTypeService paidTypeService;

    @PostMapping("/add")
    public ResponseEntity addPaidType(@RequestParam Long customerId, @RequestParam String paidType){
        try{
            paidTypeService.savePaidType(paidType, customerId);
            return ResponseEntity.ok("PaidType save");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/get")
    public ResponseEntity getOnePaidType(@RequestParam Long id){
        try{
            return ResponseEntity.ok(paidTypeService.findPaidTypeById(id));
        } catch (PaidTypeNotFoundException e){
            return ResponseEntity.badRequest().body((e.getMessage()));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/get-by-customer")
    public ResponseEntity getPaidTypesByIdCustomer(@RequestParam Long customerId){
        try{
            return ResponseEntity.ok(paidTypeService.findPaidTypeByIdCustomer(customerId));
        } catch (CustomerNotFoundException e){
            return ResponseEntity.badRequest().body((e.getMessage()));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/get/all")
    public ResponseEntity getAllPaidType(){
        try{
            return ResponseEntity.ok(paidTypeService.findAllPaidTypes());
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

//    @PutMapping("/update")
//    public ResponseEntity updateCustomer(@RequestParam String paidType){
//        try{
//            paidTypeService.updatePaidType(paidType);
//            return ResponseEntity.ok("PaidType update");
//        } catch (CustomerNotFoundException e){
//            return ResponseEntity.badRequest().body((e.getMessage()));
//        } catch (Exception e){
//            return ResponseEntity.badRequest().body(e.getMessage());
//        }
//    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deletePaidType(@PathVariable Long id){
        try{
            paidTypeService.deletePaidTypeById(id);
            return ResponseEntity.ok("PaidType delete");
        } catch (PaidTypeNotFoundException e){
            return ResponseEntity.badRequest().body((e.getMessage()));
        } catch (PaidTypeLinkedToUserException e){
            return ResponseEntity.badRequest().body((e.getMessage()));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
