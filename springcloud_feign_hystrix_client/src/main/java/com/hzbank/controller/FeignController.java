package com.hzbank.controller;

import com.hzbank.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignController {

    @Autowired
    AdminService adminService;//会提示有多个实现类，忽略

    @GetMapping("login/{username}")
    public String login(@PathVariable("username")String username){
        return adminService.login(username);
    }
}
