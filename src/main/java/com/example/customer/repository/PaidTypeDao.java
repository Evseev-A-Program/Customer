package com.example.customer.repository;

import com.example.customer.models.EPaidType;
import com.example.customer.models.PaidType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaidTypeDao extends CrudRepository<PaidType, Long> {

    PaidType findByName(EPaidType name);

//    @Modifying
//    @Query("update PaidType u set u.name = :name where u.id = :id")
//    void updateName(Long id, String name);
//
//    @Modifying
//    @Query("update PaidType u set u.customer = :customers where u.id = :id")
//    void updateCustomers(Long id, Customer customer);
}
