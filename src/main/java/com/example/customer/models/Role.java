package com.example.customer.models;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "t_role")
@Getter
@Setter
@AllArgsConstructor
@ToString
@Builder
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
   // @Transient
    @ManyToMany(mappedBy = "roles")
    private Set<Customer> users;

    public Role() {
    }

    @Override
    public String getAuthority() {
        return getName();
    }
}