package com.example.customer.forms;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class OfferForm {

    private Long id;

    private String name;

    private String image;

    private float price;

    private Long categoryId;

    private String  categoryName;

    private String characteristicName;

    private String characteristicDescription;


}