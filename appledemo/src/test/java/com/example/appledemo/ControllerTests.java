package com.example.appledemo;

import com.example.appledemo.controller.DemoController;
import com.example.appledemo.domain.DemoValue;
import com.example.appledemo.service.DemoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class ControllerTests {

    private MockMvc mockMvc;

    @Mock
    DemoService service;

    @InjectMocks
    private DemoController demoController;

    @BeforeEach
    public void init(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(demoController).build();
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
    }

    @Test
    public void test() throws Exception {
        String quote = "I have two hours today to build an app from scratch. @springboot to the rescue!";

        when(service.getQuote()).thenReturn(quote);

        MvcResult result = mockMvc.perform(get("/demo/quote")).andExpect(status().isOk()).andReturn();

        Assertions.assertNotNull(result);
    }
}
