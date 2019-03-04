package com.superatom.serviceribbon.controller;

import com.superatom.serviceribbon.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloControler {

    @Autowired
    HelloService helloService;

    @GetMapping("/hi")
    public String sayHi(@RequestParam String name){
        return helloService.hiService(name);
    }
}
