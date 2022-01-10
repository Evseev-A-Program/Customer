package com.example.customer.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;


@Getter
@Setter
@AllArgsConstructor
@Entity
@ToString
@Table
@Builder
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String city;

    private String street;

    private String country;

//    @OneToOne(cascade = CascadeType.ALL)
//    @PrimaryKeyJoinColumn
//    @JsonIgnore
//    private Customer customer;

    public Address() {

    }
}