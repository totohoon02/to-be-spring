package com.example.hellospring.config;


import com.example.hellospring.provider.WebAPiExRateProvider;
import com.example.hellospring.provider.inf.ExRateService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PaymentServiceConfig {

    @Bean
    public ExRateService exRateService() {
        return new WebAPiExRateProvider();
    }
}
