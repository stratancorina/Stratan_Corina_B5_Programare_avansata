package com.example.client;

import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class CallService {
    final Logger log = (Logger) LoggerFactory.getLogger(CallService.class);
    final String uri = "http://localhost:8081/people";

    public List<Person> getPeople() {
        log.info("Start");
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Person>> response = restTemplate.exchange(
                uri, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Person>>() {
                });
        List<Person> result = response.getBody();
        result.forEach(p -> log.info(p.toString()));
        log.info("Stop");
        return result;
    }
}
