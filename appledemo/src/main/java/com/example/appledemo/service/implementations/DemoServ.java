package com.example.appledemo.service.implementations;

import com.example.appledemo.domain.DemoObject;
import com.example.appledemo.domain.DemoValue;
import com.example.appledemo.entity.DemoResponse;
import com.example.appledemo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DemoServ implements DemoService {

    private RestTemplate restTemplate;

    @Autowired
    private void setRestTemplate(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @Override
    public String getQuote() {
        ResponseEntity<DemoObject> responseEntity = restTemplate.exchange("https://gturnquist-quoters.cfapps.io/api/random", HttpMethod.GET,null, DemoObject.class);
        String quote = responseEntity.getBody().getValue().getQuote();
        return quote;
    }

    @Override
    public String getById(int id) {
        ResponseEntity<DemoObject> responseEntity = restTemplate.exchange("https://gturnquist-quoters.cfapps.io/api/" + id, HttpMethod.GET,null, DemoObject.class);
        String quote = responseEntity.getBody().getValue().getQuote();
        return quote;
    }
}
