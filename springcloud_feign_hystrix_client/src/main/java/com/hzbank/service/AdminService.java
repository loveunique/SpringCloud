package com.hzbank.service;

import com.hzbank.service.impl.AdminServiceFallback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "SSO-SERVICE",fallback = AdminServiceFallback.class)//项目名
public interface AdminService {

    @GetMapping("admin/{username}")//要与原项目的路径相同
    String login(@PathVariable("username") String username);
}
