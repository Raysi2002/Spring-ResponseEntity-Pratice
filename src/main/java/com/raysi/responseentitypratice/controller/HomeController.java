package com.raysi.responseentitypratice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/")
    public String home(){
        return """
                <h1 style:"text-align: center"> Welcome to Home Page </h1>
                """;
    }
}
