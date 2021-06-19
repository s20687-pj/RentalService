package com.example.RentalService.Controller;


import com.example.RentalService.model.Movie;
import com.example.RentalService.service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController

public class MovieController {

    private MovieService movieservice;

    public MovieController(MovieService movieservice){
        this.movieservice = movieservice;
    }


    @GetMapping ("/getmovie/{id}")
        public ResponseEntity<Movie> getMovie(@PathVariable int id){
            return ResponseEntity.ok(movieservice.getMovie(id));
        }

    @PostMapping ("/returnmovie/{id}")
    public ResponseEntity<Movie> returnMovie(@PathVariable int id){
        return ResponseEntity.ok(movieservice.returnMovie(id));
    }

    @PostMapping ("/takemovie/{id}")
    public ResponseEntity<Movie> takeMovie(@PathVariable int id){
        return ResponseEntity.ok(movieservice.takeMovie(id));
    }





}
