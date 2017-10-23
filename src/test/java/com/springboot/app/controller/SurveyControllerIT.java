package com.springboot.app.controller;

import com.springboot.app.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SurveyControllerIT {

    @LocalServerPort
    private int port;


    @Test
    public void test(){


        String url = "http://localhost:"+port+"/surveys/Survey1/questions/Question1";
        TestRestTemplate restTemplate = new TestRestTemplate();
        String output = restTemplate.getForObject(url,String.class);
        assertEquals("<Question><id>Question1</id><description>Largest Country in the World</description><correctAnswer>Russia</correctAnswer><options><options>India</options><options>Russia</options><options>United States</options><options>China</options></options></Question>",output);
        System.out.println("Response "+ output);
    }
}