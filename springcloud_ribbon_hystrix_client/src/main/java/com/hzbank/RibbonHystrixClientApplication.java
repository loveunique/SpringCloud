package com.hzbank;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

//@SpringBootApplication
//@EnableDiscoveryClient
//@EnableHystrix
@SpringCloudApplication //等同于上面三个注解
public class RibbonHystrixClientApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(RibbonHystrixClientApplication.class).web(true).run(args);
    }
}
