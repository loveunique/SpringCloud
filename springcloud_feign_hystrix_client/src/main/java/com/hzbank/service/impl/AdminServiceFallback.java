package com.hzbank.service.impl;

import com.hzbank.service.AdminService;
import org.springframework.stereotype.Component;

@Component
public class AdminServiceFallback implements AdminService {
    @Override
    public String login(String username) {
        return "访问出错，Feign-Hystrix服务降级 -- "+username;
    }
}
