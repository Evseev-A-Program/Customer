package com.example.customer.repository;

import com.example.customer.models.EPaidType;
import com.example.customer.models.PaidType;

import org.springframework.stereotype.Repository;

@Repository
public interface PaidTypeDao extends CrudRepository<PaidType, Long> {


    PaidType findByName(EPaidType name);

}
