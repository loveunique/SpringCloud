package com.hzbank.controller;

import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RibbonController {

    @Autowired
    private RestTemplate restTemplate;//尽量不要设为private

    @GetMapping("login/{username}")
    public String login(@PathVariable("username") String username) {

        //使用@LoadBalanced注解时，使用项目名
        String object = restTemplate.getForObject("http://SSO-SERVICE/admin/" + username, String.class);

        //使用@LoadBalanced注解时，不能用url地址，要用项目名
//        String object = restTemplate.getForObject("http://localhost:8989/admin/" + username, String.class);
        return object;
    }
}
