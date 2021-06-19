package com.example.RentalService.NBP;

import com.example.RentalService.model.Movie;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Controller {

        private Service service;

        public Controller(Service service){
            this.service = service;
        }

        @ApiOperation(value = "get average currency rate", notes ="provide currency and number of days")

        @GetMapping("/nbp/{waluta}")
        public ResponseEntity<Currency> api(@ApiParam(value = "Currency", example = "GBP")@PathVariable String waluta, @ApiParam(value = "days", example = "10")@RequestParam int dni)
        {
            return ResponseEntity.ok(service.getPrice(waluta,dni));
        }

        @GetMapping("/nbp/avarage/{waluta}")
        public ResponseEntity<Double> getAvarage(@ApiParam(value = "Currency", example = "GBP")@PathVariable String waluta, @ApiParam(value = "days", example = "10")@RequestParam int dni)
        {
            return ResponseEntity.ok(service.getAvarage(waluta,dni));
        }


}
///@PathVariable String waluta, @RequestParam int dni