package models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import javax.persistence.*;


@Getter
@Setter
@AllArgsConstructor
@Entity
@Table
@Builder
@Log4j
public class Addresses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String city;

    private String state;

    private String country;

    public Addresses() {

    }
}