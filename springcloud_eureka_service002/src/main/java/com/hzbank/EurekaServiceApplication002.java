package com.hzbank;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EurekaServiceApplication002 {
    public static void main(String[] args) {
        new SpringApplicationBuilder(EurekaServiceApplication002.class).web(true).run(args);
    }
}
