package com.example.RentalService.NBP;

import com.example.RentalService.Exception.MyErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.util.List;

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

    public double getAvarage (String waluta, int dni){
        Currency currency = restTemplate.getForObject("http://api.nbp.pl/api/exchangerates/rates/a/"+waluta+"/last/"+dni+"/?format=json", Currency.class);
        List<Rate> rate = currency.getRates();
        double whole =0;
        for(Rate rat :rate){
            whole += rat.getMid();
        }
        double srednia = whole/dni;
        return srednia;
    }
}
