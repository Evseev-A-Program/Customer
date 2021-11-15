package services;

import lombok.extern.log4j.Log4j;
import models.Addresses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.AddressesDao;

import javax.transaction.Transactional;
import java.util.Optional;

@Log4j
@Service
public class AddressesService {

    @Autowired
    private AddressesDao addressesDao;

    @Transactional
    public Optional<Addresses> findAddressById(long id) {
        return addressesDao.findById(id);
    }

    @Transactional
    public void saveAddresses(Addresses addresses) {
        addressesDao.save(addresses);
        log.info("Addresses save");
    }

    @Transactional
    public void updateCityAddressesById(long id, String city) {
        addressesDao.updateCity(id,city);
        log.info("Address update");
    }

    @Transactional
    public void updateStateAddressesById(long id, String state) {
        addressesDao.updateState(id,state);
        log.info("Address update");
    }

    @Transactional
    public void updateCountryAddressesById(long id, String country) {
        addressesDao.updateCountry(id,country);
        log.info("Address update");
    }
}
