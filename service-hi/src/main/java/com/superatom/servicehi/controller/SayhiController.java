package com.superatom.servicehi.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SayhiController {

    @Value("${server.port}")
    private String port;

    @RequestMapping("/hi")
    public String sayhi(@RequestParam(value = "name", defaultValue = "superatom") String name){
        return "hi " + name + " , I am from port: " + port;
    }
}
