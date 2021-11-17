package com.example.customer.models;

import lombok.*;

import javax.persistence.*;


@Getter
@Setter
@AllArgsConstructor
@ToString
@Entity
@Table
@Builder
public class PaidType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public PaidType() {

    }
}
