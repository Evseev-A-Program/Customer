package com.example.customer.clients;

import com.example.customer.transfer.transfer.CategoryDTO;
import com.example.customer.transfer.transfer.CharacteristicDTO;
import com.example.customer.transfer.transfer.OfferDTO;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class OfferClients {

    public static boolean checkPaidType(Long id)
    {
        final String url = "http://localhost:8081/offer/check-paid-type?paidTypeId=" + id;

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, Boolean.class);
    }


    public static List<Object> getOffersNotNull()
    {
        final String url = "http://localhost:8081/offer/get/all-not-null";
        RestTemplate restTemplate = new RestTemplate();

        ParameterizedTypeReference<List<Object>> pr = new ParameterizedTypeReference<List<Object>>() {};
        ResponseEntity<List<Object>> exchange = restTemplate.exchange(url, HttpMethod.GET, null, pr);

        return exchange.getBody();
    }

    public static List<Object> getOffers()
    {
        final String url = "http://localhost:8081/offer/get/all";
        RestTemplate restTemplate = new RestTemplate();

        ParameterizedTypeReference<List<Object>> pr = new ParameterizedTypeReference<List<Object>>() {};
        ResponseEntity<List<Object>> exchange = restTemplate.exchange(url, HttpMethod.GET, null, pr);

        return exchange.getBody();
    }


    public static List<Object> getCategory()
    {
        final String url = "http://localhost:8081/category/get/all";
        RestTemplate restTemplate = new RestTemplate();

        ParameterizedTypeReference<List<Object>> pr = new ParameterizedTypeReference<List<Object>>() {};
        ResponseEntity<List<Object>> exchange = restTemplate.exchange(url, HttpMethod.GET, null, pr);

        return exchange.getBody();
    }

    public static void addCategory(String name)
    {
        final String url = "http://localhost:8081/category/add";
        RestTemplate restTemplate = new RestTemplate();
        CategoryDTO category = CategoryDTO.builder()
                        .name(name)
                        .build();
        restTemplate.postForEntity(url, category, String.class);
    }

    public static List<Object> getCharacteristic()
    {
        final String url = "http://localhost:8081/characteristic/get/all";
        RestTemplate restTemplate = new RestTemplate();

        ParameterizedTypeReference<List<Object>> pr = new ParameterizedTypeReference<List<Object>>() {};
        ResponseEntity<List<Object>> exchange = restTemplate.exchange(url, HttpMethod.GET, null, pr);

        return exchange.getBody();
    }

    public static void addCharacteristic(String name, String description)
    {
        final String url = "http://localhost:8081/characteristic/add";
        RestTemplate restTemplate = new RestTemplate();
        CharacteristicDTO characteristic = CharacteristicDTO.builder()
                .name(name)
                .description(description)
                .build();
        restTemplate.postForEntity(url, characteristic, String.class);
    }

    public static Object getOffer(Long id)
    {
        final String url = "http://localhost:8081/offer/get?id={1}";
        RestTemplate restTemplate = new RestTemplate();
        Object offerId = id;
        ResponseEntity<Object> entity = restTemplate.getForEntity(url, Object.class,offerId);

        return entity.getBody();
    }

    public static void addPaidType(Long offerId, Long paidTypeId)
    {
        final String url = "http://localhost:8081/offer/add-paid-type?id={1}&paidTypeId={2}";
        RestTemplate restTemplate = new RestTemplate();
        Object offer = offerId;
        Object paidType = paidTypeId;
        restTemplate.getForEntity(url, String.class, offer, paidType);
    }

    public static void delPaidType(Long offerId, Long paidTypeId)
    {
        final String url = "http://localhost:8081/offer/del-paid-type?id={1}&paidTypeId={2}";
        RestTemplate restTemplate = new RestTemplate();
        Object offer = offerId;
        Object paidType = paidTypeId;
        restTemplate.getForEntity(url, String.class, offer, paidType);
    }

    public static void addOffer(OfferDTO offerDTO)
    {
        final String url = "http://localhost:8081/offer/add";
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForEntity(url, offerDTO, String.class);

    }

    public static void updateOffer(OfferDTO offerDTO)
    {
        final String url = "http://localhost:8081/offer/update";
        RestTemplate restTemplate = new RestTemplate();
       // restTemplate.postForEntity(url, offerDTO, String.class);
        restTemplate.put(url, offerDTO);

    }

    public static void addCategoryFromOffer(Long offerId, Long categoryId)
    {
        final String url = "http://localhost:8081/offer/add-category?id={1}&categoryId={2}";
        RestTemplate restTemplate = new RestTemplate();
        Object offer = offerId;
        Object category = categoryId;
        restTemplate.getForEntity(url, String.class, offer, category);
    }

    public static void addCharacteristicFromOffer(Long offerId, Long characteristicId)
    {
        final String url = "http://localhost:8081/offer/add-characteristic?id={1}&characteristicId={2}";
        RestTemplate restTemplate = new RestTemplate();
        Object offer = offerId;
        Object characteristic = characteristicId;
        restTemplate.getForEntity(url, String.class, offer, characteristic);
    }

}
