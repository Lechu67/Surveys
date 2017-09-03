package com.springboot.app.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Welcome {

    @Autowired
    WelcomeService welcome;

    @RequestMapping("/welcome")
    public String welcome() {
        return welcome.welcome2();
    }
}

@Component
class WelcomeService {

    public String welcome2(){
        return"Goodbye Modified";
    }
}
