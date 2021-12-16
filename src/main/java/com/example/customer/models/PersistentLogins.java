package com.example.customer.models;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table
public class PersistentLogins {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    @PrimaryKeyJoinColumn
    private String series;

    private String token;

    private Timestamp last_used;

    public PersistentLogins() {

    }
}
