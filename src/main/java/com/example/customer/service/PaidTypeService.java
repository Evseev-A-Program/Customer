package com.example.customer.service;

import com.example.customer.models.Customer;
import com.example.customer.models.PaidType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.customer.repository.PaidTypeDao;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class PaidTypeService {

    @Autowired
    private PaidTypeDao paidTypeDao;

    public Optional<PaidType> findPaidTypeById(Long id) {
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

    public void savePaidType(PaidType paidType) {
        paidTypeDao.save(paidType);
    }

    public void updateNamePaidTypeById(Long id, String name) {
        paidTypeDao.updateName(id,name);

    }

    public void updateCustomersPaidTypeById(Long id, Customer customer) {
        paidTypeDao.updateCustomers(id, customer);
    }

}
