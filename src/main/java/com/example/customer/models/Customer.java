package com.example.customer.models;

import lombok.*;

import javax.persistence.*;
import java.util.Set;


@Getter
@Setter
@AllArgsConstructor
@ToString
@Entity
@Table
@Builder
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String firstname;

    private String lastname;

    @Column(unique = true)
    private String email;

    private String password;

    @Column(unique = true)
    private String phoneNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    @ManyToMany
    @JoinTable(joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "paid_type_id"))
    private Set<PaidType> paidTypes;

    public void addPaidType(PaidType paidType) {
        paidTypes.add(paidType);
    }

    public void deletePaidType() {
        paidTypes.forEach(paidType -> paidType.getCustomers().remove(this));
    }

    public Customer() {
    }
}
