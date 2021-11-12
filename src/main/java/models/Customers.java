package models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@Entity
@Table
@Builder
@Log4j
public class Customers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String firstname;

    private String lastname;

    private  String email;

    private String password;

    private String phone_number;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="addresses_id")
    private Addresses addressId;

    @OneToMany(mappedBy = "customers", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PaidType> paidTypeList;

    public Customers() {

    }
}
