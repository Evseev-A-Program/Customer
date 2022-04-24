package com.example.customer.clients;

import com.example.customer.transfer.transfer.CategoryDTO;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class OrderClients {

    public static void addOrder(Long idCustomer, Long idOffer)
    {
        final String url = "http://localhost:8082/orders/add?customerId={1}&offerId={2}";
        RestTemplate restTemplate = new RestTemplate();
        Object customer = idCustomer;
        Object offer = idOffer;
        restTemplate.getForEntity(url, String.class, customer, offer);
    }

    public static Object getOrderByIdCustomer(Long id)
    {
        RestTemplate restTemplate = new RestTemplate();
        Object customerId = id;

        final String url = "http://localhost:8082/orders/get?customerId=" + customerId;

        ParameterizedTypeReference<List<Object>> pr = new ParameterizedTypeReference<List<Object>>() {};
        ResponseEntity<List<Object>> exchange = restTemplate.exchange(url, HttpMethod.GET, null, pr);

        return exchange.getBody();
    }


    public static Object getIdOrdersByIdCustomer(Long id)
    {
        RestTemplate restTemplate = new RestTemplate();
        Object customerId = id;

        final String url = "http://localhost:8082/orders/get_id_offers?customerId=" + customerId;

        ParameterizedTypeReference<List<Object>> pr = new ParameterizedTypeReference<List<Object>>() {};
        ResponseEntity<List<Object>> exchange = restTemplate.exchange(url, HttpMethod.GET, null, pr);

        return exchange.getBody();
    }

    public static void buyOrder(Long id)
    {
        RestTemplate restTemplate = new RestTemplate();
        Object customerId = id;
        final String url = "http://localhost:8082/orders/buy?customerId=" + customerId;
        restTemplate.postForEntity(url, customerId, String.class);
    }
}
