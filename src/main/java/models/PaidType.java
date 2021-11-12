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
public class PaidType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customers_id")
    private Customers customers;

    public PaidType() {

    }
}
