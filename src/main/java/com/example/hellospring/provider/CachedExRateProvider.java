package com.example.hellospring.provider;

import com.example.hellospring.domain.PaymentRequestDTO;
import com.example.hellospring.provider.inf.ExRateProvider;

import java.io.IOException;
import java.math.BigDecimal;

public class CachedExRateProvider implements ExRateProvider {
    private final ExRateProvider target;
    private BigDecimal rate;

    public CachedExRateProvider(ExRateProvider target) {
        this.target = target;
    }

    @Override
    public BigDecimal getExRate(PaymentRequestDTO requestDTO) throws IOException {
        // decorator pattern
        if(rate == null) {
            System.out.println("get rate");
            this.rate = target.getExRate(requestDTO);
        }

        return rate;
    }
}
