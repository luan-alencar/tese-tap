package com.unifacisa.tap.restclientservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class RestclientserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestclientserviceApplication.class, args);
    }

    @Bean
    public static RestClient createRestClient() {
        RestTemplate restTemplate = new RestTemplate();
        RestClient restClient = RestClient.create(restTemplate);
        return restClient;
    }
}
