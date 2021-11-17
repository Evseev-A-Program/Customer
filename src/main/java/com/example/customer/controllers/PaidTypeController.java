package com.example.customer.controllers;

import com.example.customer.exception.CustomerAlreadyExistException;
import com.example.customer.exception.CustomerNotFoundException;
import com.example.customer.exception.PaidTypeIncorrectException;
import com.example.customer.exception.PaidTypeNotFoundException;
import com.example.customer.models.Customer;
import com.example.customer.models.PaidType;
import com.example.customer.models.ePaidType;
import com.example.customer.service.CustomerService;
import com.example.customer.service.PaidTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/paidtype")
public class PaidTypeController {

    @Autowired
    private PaidTypeService paidTypeService;

    @PostMapping("/add")
    public ResponseEntity addPaidType(@RequestBody PaidType paidType){
        try{
            paidTypeService.savePaidType(paidType);
            return ResponseEntity.ok("PaidType save");
        } catch (PaidTypeIncorrectException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch (Exception e){
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

    @GetMapping("/get/all")
    public ResponseEntity getAllPaidType(){
        try{
            return ResponseEntity.ok(paidTypeService.findAllPaidTypes());
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
