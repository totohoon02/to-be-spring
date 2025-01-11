package com.example.hellospring.config;


import com.example.hellospring.provider.CachedExRateProvider;
import com.example.hellospring.provider.WebAPiExRateProvider;
import com.example.hellospring.provider.inf.ExRateProvider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class PaymentServiceConfig {
    @Bean
    public ExRateProvider exRateProvider() {
        return new WebAPiExRateProvider();
    }

    @Bean
    @Primary
    ExRateProvider cachedExRateProvider() {
        return new CachedExRateProvider(exRateProvider());
    }
}
