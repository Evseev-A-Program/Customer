package com.example.customer.repository;

import com.example.customer.models.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressDao extends CrudRepository<Address, Long> {


//    @Modifying
//    @Query("update Addresses u set u.city = :city where u.id = :id")
//    void updateCity(long id, String city);
//
//    @Modifying
//    @Query("update Addresses u set u.state = :city where u.id = :id")
//    void updateState(long id, String state);
//
//    @Modifying
//    @Query("update Addresses u set u.country = :city where u.id = :id")
//    void updateCountry(long id, String country);

}
