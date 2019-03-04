package com.superatom.serviceribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "hiError")
    public String hiService(String name){
        return restTemplate.getForObject("http://SERVICE-HI/hi?name=" + name, String.class);
    }

    /**
     * 如果hiService服务调用不通，那么就会调用此方法
     * 通过上面的@HystrixCommand配置
     * @param name
     * @return
     */
    public String hiError(String name){
        return "hi," + name + ",sorry,error";
    }
}
