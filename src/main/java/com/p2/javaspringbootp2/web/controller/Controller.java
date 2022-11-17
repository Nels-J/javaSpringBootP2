package com.p2.javaspringbootp2.web.controller;

/*
 * @author nelsj
 * @Date 17/11/2022
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
public class Controller {

    // -------------- ATTRIBUTE(s) -------------- //
    // ------------- CONSTRUCTOR(s) ------------- //
    private Controller() {

    }

    // --------- GETTER(s) & SETTER(s) ---------- //

    // --------------- METHODS(s) --------------- //
    @RestController
    public class getAllCars {
        @Autowired
        RestTemplate restTemplate;

        @GetMapping("/getcarslist")
        public String getCarList() {
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            HttpEntity<String> entity = new HttpEntity<String>(headers);

            return restTemplate.exchange("http://localhost:8081/cars", HttpMethod.GET, entity, String.class).getBody();
        }
    }

}
