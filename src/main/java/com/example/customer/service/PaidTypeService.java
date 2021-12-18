package com.example.customer.service;

import com.example.customer.clients.OfferClients;
import com.example.customer.exception.*;
import com.example.customer.models.Customer;
import com.example.customer.models.PaidType;
import com.example.customer.models.EPaidType;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.customer.repository.PaidTypeDao;

import java.util.List;

@Service
@AllArgsConstructor
public class PaidTypeService {

    private final PaidTypeDao paidTypeDao;
    private final CustomerService customerService;

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
        PaidType paidType = findPaidTypeById(id);

        if (!paidType.getCustomers().isEmpty()) {
            throw new PaidTypeLinkedToUserException("PaidType is already linked to the user");
        }

//        if (!OfferClients.checkPaidType(id)){
//            throw new PaidTypeLinkedToUserException("PaidType is already linked to the offer");
//        }

        paidTypeDao.deleteById(id);
    }

    public void savePaidType(String paidType, Long customerId) throws CustomerNotFoundException, CustomerAlreadyExistException, PaidTypeAlreadyExistException {

        EPaidType name = EPaidType.valueOf(paidType);
        PaidType paidTypeNew = paidTypeDao.findByName(name);
        Customer customer = customerService.findCustomerById(customerId);

        if (paidTypeNew != null) {
            customer.addPaidType(paidTypeNew);
            customerService.saveCustomers(customer);
        } else {
            paidTypeNew = PaidType.builder().name(name).build();
            paidTypeDao.save(paidTypeNew);
            customer.addPaidType(paidTypeNew);
            customerService.saveCustomers(customer);
        }




    }




}
