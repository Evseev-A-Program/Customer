package com.example.customer.transfer.customerDTO;

import com.example.customer.models.Customer;
import com.example.customer.user.UserForm;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class CustomerDTO {
    private String firstName;

    private String lastName;

    private String city;

    private String street;

    private String country;

    public static CustomerDTO from(Customer customer) {
        return CustomerDTO.builder()
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .city(customer.getAddress().getCity())
                .street(customer.getAddress().getStreet())
                .country(customer.getAddress().getCountry())
                .build();
    }
}
