package com.controller;

import com.domain.Currency;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/hello")
public class HelloController {


    @RequestMapping("/sayHello")
    public String greet() {
        return "Hello Java Developers";
    }

    @CrossOrigin
    @RequestMapping("/currency/rate")
    public Currency rate() throws IOException {
        Currency currency = new Currency();
        currency.setRate(101.2);
        return currency;
    }

    @GetMapping("/currency/rate/{from}")
    public Currency rateWithParameter(@PathVariable("from") int from) throws IOException {
        Currency currency = new Currency();
        System.out.println(from);
        return currency;
    }




}