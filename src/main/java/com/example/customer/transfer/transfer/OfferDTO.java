package com.example.customer.transfer.transfer;

import com.example.customer.forms.OfferForm;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Builder
@Getter
@Setter
public class OfferDTO {

    private Long id;

    private String name;

    private String image;

    private float price;

    private Category category;

    public static OfferDTO fromDTO(OfferForm offerForm){
        return OfferDTO.builder()
                .name(offerForm.getName())
                .image(offerForm.getImage())
                .price(offerForm.getPrice())
                .category(Category.builder()
                        .id(offerForm.getCategoryId())
                        .name(offerForm.getCategoryName())
                        .build())
                .build();
    }


    }



