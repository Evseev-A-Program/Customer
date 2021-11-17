package com.example.customer.service;

import com.example.customer.controllers.PaidTypeController;
import com.example.customer.exception.CustomerNotFoundException;
import com.example.customer.exception.PaidTypeIncorrectException;
import com.example.customer.exception.PaidTypeNotFoundException;
import com.example.customer.models.Customer;
import com.example.customer.models.PaidType;
import com.example.customer.models.ePaidType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.customer.repository.PaidTypeDao;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class PaidTypeService {

    @Autowired
    private PaidTypeDao paidTypeDao;

    public Optional<PaidType> findPaidTypeById(Long id) throws PaidTypeNotFoundException {
        PaidType paidType = paidTypeDao.findById(id).get();
        if (paidType == null) {
            throw new PaidTypeNotFoundException("PaidType Not Found");
        }
        return paidTypeDao.findById(id);
    }

    public Iterable<PaidType> findAllPaidTypes(){
        return  paidTypeDao.findAll();
    }

    public void deletePaidTypeById(Long id){
        paidTypeDao.deleteById(id);
    }

    public void deletePaidTypeAll(){
        paidTypeDao.deleteAll();
    }

    public void savePaidType(PaidType paidType) throws PaidTypeIncorrectException {
        Boolean correctName = false;

        for (ePaidType e : ePaidType.values()){
            if (e.name().equals(paidType.getName())) correctName = true;
        }

        if(correctName == true) paidTypeDao.save(paidType);
        else throw new PaidTypeIncorrectException("PaidType Incorrect");

    }

    public void updateNamePaidTypeById(Long id, String name) {
        paidTypeDao.updateName(id,name);

    }

    public void updateCustomersPaidTypeById(Long id, Customer customer) {
        paidTypeDao.updateCustomers(id, customer);
    }

}
