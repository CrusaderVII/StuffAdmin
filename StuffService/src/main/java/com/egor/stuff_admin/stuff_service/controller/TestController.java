package com.egor.stuff_admin.stuff_service.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Value("${test.prop}")
    private String test;

    @GetMapping("/test")
    public void getTest() {
        System.out.println(test);
    }

}
