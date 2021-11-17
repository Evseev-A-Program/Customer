package com.example.customer.controllers;

import com.example.customer.exception.CustomerAlreadyExistException;
import com.example.customer.exception.CustomerNotFoundException;
import com.example.customer.models.Customer;
import com.example.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity addCustomer(@RequestBody Customer customer){
        try{
            customerService.saveCustomers(customer);
            return ResponseEntity.ok("Customer SAVE");
        }catch (CustomerAlreadyExistException e){
            return ResponseEntity.badRequest().body((e.getMessage()));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
//
    @GetMapping("/get")
    public ResponseEntity getOneCustomer(@RequestParam Long id){
        try{
            return ResponseEntity.ok(customerService.findCustomerById(id));
        } catch (CustomerNotFoundException e){
            return ResponseEntity.badRequest().body((e.getMessage()));
        } catch (Exception e){
            return ResponseEntity.badRequest().body("ERROR!!!");
        }
    }

    @PostMapping
    public ResponseEntity updateCustomer(@RequestBody Customer customer){
        try{
            customerService.updateCustomerById(customer);
            return ResponseEntity.ok("Customer update");
        } catch (CustomerNotFoundException e){
            return ResponseEntity.badRequest().body((e.getMessage()));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


//
//    @Autowired
//    public CustomersController(CustomersService customersService) {
//        this.customersService = customersService;
//    }
//
//    @GetMapping(value = "/customers/all")
//    public ResponseEntity<List<Customers>> read() {
//        List<Customers> clients = (List<Customers>) customersService.findAllCustomers();
//
//        return clients != null &&  !clients.isEmpty()
//                ? new ResponseEntity<>(clients, HttpStatus.OK)
//                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }



}
