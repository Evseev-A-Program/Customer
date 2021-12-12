package com.example.customer.user;

import com.example.customer.models.Address;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
public class UserForm {

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private String phoneNumber;

    private String city;

    private String street;

    private String country;
}
