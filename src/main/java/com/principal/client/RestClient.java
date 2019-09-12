package com.principal.client;


import org.springframework.web.client.RestTemplate;

import com.principal.model.Person;

public class RestClient {

    public static void main(String args[]) {
        RestTemplate restTemplate = new RestTemplate();
        Person quote = restTemplate.getForObject("http://localhost:8080/application/users", Person.class);
        System.out.println(quote.toString());
       
        	System.out.println(quote.getName());
        	
        System.out.println(quote.getSalary());
    }
}