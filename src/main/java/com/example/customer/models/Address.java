package com.example.customer.models;


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

    private String state;

    private String country;

    public Address() {

    }
}