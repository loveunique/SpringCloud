package com.hzbank.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("SSO-SERVICE")//项目名
public interface AdminService {

    @GetMapping("admin/{username}")//要与原项目的路径相同
    String login(@PathVariable("username") String username);
}
