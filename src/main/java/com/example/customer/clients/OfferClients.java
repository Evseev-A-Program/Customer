package com.example.customer.clients;

import org.springframework.web.client.RestTemplate;

public class OfferClients {

    public static boolean checkPaidType(Long id)
    {
        final String uri = "http://localhost:8081/offer/check-paid-type?paidTypeId=" + id;

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(uri, Boolean.class);
    }
}
