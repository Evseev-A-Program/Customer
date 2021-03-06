package com.example.customer.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class PaidType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Enumerated(EnumType.STRING)
    private EPaidType name;

    @Enumerated(value = EnumType.STRING)
    private State state;

    @ManyToMany(mappedBy = "paidTypes")
    @JsonIgnore
    private Set<Customer> customers;

    public PaidType() {
    }
}
