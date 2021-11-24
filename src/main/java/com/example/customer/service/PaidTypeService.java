package com.example.customer.service;

import com.example.customer.exception.*;
import com.example.customer.models.Customer;
import com.example.customer.models.PaidType;
import com.example.customer.models.EPaidType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.customer.repository.PaidTypeDao;

import java.util.List;

@Service
public class PaidTypeService {

    @Autowired
    private PaidTypeDao paidTypeDao;

    @Autowired
    private CustomerService customerService;

    public PaidType findPaidTypeById(Long id) throws PaidTypeNotFoundException {
        PaidType paidType = paidTypeDao.findById(id).get();
        if (paidType == null) {
            throw new PaidTypeNotFoundException("PaidType Not Found");
        }
        return paidType;
    }

    public Iterable<PaidType> findPaidTypeByIdCustomer(Long id) throws CustomerNotFoundException {
        Customer customer = customerService.findCustomerById(id);
        return customer.getPaidTypes();
    }

    public Iterable<PaidType> findAllPaidTypes(){
        return  paidTypeDao.findAll();
    }

    public void deletePaidTypeById(Long id) throws PaidTypeNotFoundException, PaidTypeLinkedToUserException {
        PaidType paidType = paidTypeDao.findById(id).get();
        if (paidType == null) {
            throw new PaidTypeNotFoundException("PaidType Not Found");
        }

        if (paidType.getCustomers().equals(null)) {
            throw new PaidTypeLinkedToUserException("PaidType is already linked to the user");
        }
        paidTypeDao.deleteById(id);
    }

    public void savePaidType(String paidType, Long customerId) throws CustomerNotFoundException, CustomerAlreadyExistException, PaidTypeAlreadyExistException {

        EPaidType name = EPaidType.valueOf(paidType);
        if (paidTypeDao.findByName(name) != null) throw new PaidTypeAlreadyExistException("PaidType already exists");

        Customer customer = customerService.findCustomerById(customerId);

        PaidType paidTypeNew = PaidType.builder().name(name).build();
        paidTypeDao.save(paidTypeNew);
        customer.addPaidType();
        customerService.saveCustomers(customer);

//        boolean correctName = false;
//        for (EPaidType e : EPaidType.values()){
//            if (e.name().equals(paidType)) {
//                correctName = true;
//                break;
//            }
//        }

//        if(correctName) {
//            Customer customer = customerService.findCustomerById(customerId);
//            paidType.setCustomer(customer);
//            paidTypeDao.save(paidType);
//        }
//        else throw new PaidTypeIncorrectException("PaidType Incorrect");
    }


}
