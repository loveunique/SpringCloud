package com.hzbank;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class RibbonClientApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(RibbonClientApplication.class).web(true).run(args);
    }
}
