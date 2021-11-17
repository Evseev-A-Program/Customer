package com.example.customer.service;

import com.example.customer.models.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.customer.repository.AddressDao;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    private AddressDao addressDao;

    public Optional<Address> findAddressById(Long id) {
        return addressDao.findById(id);
    }

    public Iterable<Address> findAllAddresses(){
        return  addressDao.findAll();
    }

    public void deleteAddressesById(Long id){
        addressDao.deleteById(id);
    }

    public void deleteAllAddresses(){
        addressDao.deleteAll();
    }

    public void saveAddresses(Address address) {
        addressDao.save(address);
    }

//    @Transactional
//    public void updateCityAddressesById(long id, String city) {
//        addressesDao.updateCity(id,city);
//    }
//
//    @Transactional
//    public void updateStateAddressesById(long id, String state) {
//        addressesDao.updateState(id,state);
//    }
//
//    @Transactional
//    public void updateCountryAddressesById(long id, String country) {
//        addressesDao.updateCountry(id,country);
//    }
}
