package com.example.RentalService.service;

import com.example.RentalService.Exception.MyErrorHandler;
import com.example.RentalService.model.Movie;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MovieService {

    private RestTemplate restTemplate;

    public MovieService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
        restTemplate.setErrorHandler(new MyErrorHandler());
    }




    public Movie getMovie(int id) {
        return restTemplate.getForObject("http://localhost:8080/movies/" +id, Movie.class);
    }
    public Movie returnMovie(int id) {
        return restTemplate.postForObject("http://localhost:8080/returnmovie/" +id,null,Movie.class);
    }

    public Movie takeMovie(int id) {
        return restTemplate.postForObject("http://localhost:8080/takemovie/" +id,null,Movie.class);
    }
}
