package com.example.appledemo.controller;


import com.example.appledemo.domain.DemoObject;
import com.example.appledemo.domain.DemoValue;
import com.example.appledemo.entity.DemoResponse;
import com.example.appledemo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/demo")
public class DemoController {

    private DemoService service;

    @Autowired
    private void setService(DemoService service){
        this.service = service;
    }

    @GetMapping("/quote")
    public DemoResponse getQuote(){
        DemoResponse output = new DemoResponse();
        String quote = service.getQuote();
        output.setQuote(quote);
        return output;
    }

    @GetMapping("/{id}")
    public DemoResponse getById(@PathVariable int id){
        DemoResponse output = new DemoResponse();
        String quote = service.getById(id);
        output.setQuote(quote);
        return output;
    }
}
