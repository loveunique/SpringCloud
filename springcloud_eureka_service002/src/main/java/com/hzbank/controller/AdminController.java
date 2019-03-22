package com.hzbank.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

    @Value("${server.port}")
    private String port;//端口号

    @Value("${spring.application.name}")
    private String applicationName;//项目名称

    @GetMapping("/admin/{username}")
    public String admin(@PathVariable("username") String username){
        return "当前项目："+applicationName+"："+port+" username: -- "+username;
    }
}
