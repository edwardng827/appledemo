package com.example.appledemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestConfig {

    @Value("${api.uri}")
    private String apiUri;

    private RestTemplateBuilder builder;

    @Autowired
    private void setBuilder(RestTemplateBuilder builder){
        this.builder = builder;
    }

    @Bean
    public RestTemplate restClient(){
        return builder.build();
    }

    public String getApiUr() {
        return apiUri;
    }

    public void setApiUri(String apiUri){
        this.apiUri = apiUri;
    }
}
