package com.hzbank.config;

import com.hzbank.filter.AccessFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ZuulConfig {

    @Bean
    public AccessFilter getAccessFilter(){
        return new AccessFilter();
    }
}
