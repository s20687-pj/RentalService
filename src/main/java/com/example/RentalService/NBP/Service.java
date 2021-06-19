package com.example.RentalService.NBP;

import com.example.RentalService.Exception.MyErrorHandler;
import org.springframework.web.client.RestTemplate;

@org.springframework.stereotype.Service
public class Service {

    private RestTemplate restTemplate;

    public Service(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
        restTemplate.setErrorHandler(new MyErrorHandler());
    }

    public Currency getPrice(String waluta, int dni){
        return restTemplate.getForObject("http://api.nbp.pl/api/exchangerates/rates/a/"+waluta+"/last/"+dni+"/?format=json", Currency.class);
    }
}
