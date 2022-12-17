package com.tbd.lab2.services;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Clase para testear los servicioss
 */
@RestController
public class TestService {
    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }
}