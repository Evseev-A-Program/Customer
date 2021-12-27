package com.example.customer.transfer.OfferDTO;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class OfferDTO {

    private Long id;

    private String name;

    private float price;

   // private List<Long> paidTypesId;


   // private Set<Characteristic> characteristics;

    private String categoryName;

}

