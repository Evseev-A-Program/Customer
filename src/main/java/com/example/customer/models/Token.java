//package com.example.customer.models;
//
//import lombok.*;
//
//import javax.persistence.*;
//
//
//@Getter
//@Setter
//@AllArgsConstructor
//@Entity
//@Table
//@Builder
//public class Token {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String value;
//
//    @ManyToOne
//    @JoinColumn(name = "customer_id")
//    private Customer customer;
//
//    public Token() {
//
//    }
//}