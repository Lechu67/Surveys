package com.springboot.app.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Welcome {

    @Autowired
    WelcomeService welcome;

    @RequestMapping("/welcome")
    public String welcome() {
        return welcome.welcomeMessage();
    }
}

@Component
class WelcomeService {

    @Value("${welcome.message}")
    private String welcome;
    @Value("${app.name}")
    private String version;

    public String welcomeMessage(){
        return welcome+version;
    }
}

