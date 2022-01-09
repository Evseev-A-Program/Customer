package com.example.customer.delete;

import com.example.customer.exception.CustomerAlreadyExistException;
import com.example.customer.exception.CustomerNotFoundException;
import com.example.customer.models.Customer;
import com.example.customer.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/customerss")
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    @PostMapping("/add")
    public ResponseEntity addCustomer(@RequestBody Customer customer){
        try{
            customerService.saveCustomers(customer);
            return ResponseEntity.ok("Customer save");
        }catch (CustomerAlreadyExistException e){
            return ResponseEntity.badRequest().body((e.getMessage()));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/get")
    public ResponseEntity getOneCustomer(@RequestParam Long id){
        try{
            return ResponseEntity.ok(customerService.findCustomerById(id));
        } catch (CustomerNotFoundException e){
            return ResponseEntity.badRequest().body((e.getMessage()));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/get/all")
    public ResponseEntity getAllCustomer(){
        try{
            return ResponseEntity.ok(customerService.findAllCustomers());
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/update")
    public ResponseEntity updateCustomer(@RequestBody Customer customer){
        try{
            customerService.saveCustomers(customer);
            return ResponseEntity.ok("Customer update");
        } catch (CustomerNotFoundException e){
            return ResponseEntity.badRequest().body((e.getMessage()));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCustomer(@PathVariable Long id){
        try{
            customerService.deleteCustomersById(id);
            return ResponseEntity.ok("Customer delete");
        } catch (CustomerNotFoundException e){
            return ResponseEntity.badRequest().body((e.getMessage()));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
