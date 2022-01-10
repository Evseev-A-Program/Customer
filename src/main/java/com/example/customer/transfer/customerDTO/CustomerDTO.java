package com.example.customer.transfer.customerDTO;

import com.example.customer.models.Customer;
import com.example.customer.models.PaidType;
import com.example.customer.models.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class CustomerDTO {

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private String city;

    private String street;

    private String country;

    private Role role;

  //  private List<String> paidTypes;

    public static CustomerDTO from(Customer customer) {
        return CustomerDTO.builder()
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .phoneNumber(customer.getPhoneNumber())
                .city(customer.getAddress().getCity())
                .street(customer.getAddress().getStreet())
                .country(customer.getAddress().getCountry())
                .role(customer.getRole())
//                .paidTypes(customer.getPaidTypes().stream()
//                                .map(pt -> pt.getName()
//                                .name())
//                                .collect(Collectors.toList()))
                .build();
    }
}
