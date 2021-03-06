package com.example.customer.models;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
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
    private String firstName;

    private String lastName;

    @Column(unique = true)
    private String email;

    private String hashPassword;

    @Enumerated(value = EnumType.STRING)
    private Role role;
    @Enumerated(value = EnumType.STRING)
    private State state;

    @Column(unique = true)
    private String phoneNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "paid_type_id"))
    private Set<PaidType> paidTypes;

    public void addPaidType(PaidType paidType) {
        paidTypes.add(paidType);
    }

    public void deletePaidType(PaidType paidType) {
        paidTypes.remove(paidType);
    }

    public Customer() {
    }

}
