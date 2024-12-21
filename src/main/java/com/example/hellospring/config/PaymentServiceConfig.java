package com.example.hellospring.config;


import com.example.hellospring.service.PaymentService;
import com.example.hellospring.service.WebAPiExRatePaymentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PaymentServiceConfig {

    @Bean
    public PaymentService paymentService() {
        return new WebAPiExRatePaymentService();
    }
}
