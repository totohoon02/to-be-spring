package com.example.hellospring.provider;

import com.example.hellospring.domain.PaymentRequestDTO;
import com.example.hellospring.provider.inf.ExRateProvider;

import java.io.IOException;
import java.math.BigDecimal;

public class SimpleExRateProvider implements ExRateProvider {
    @Override
    public BigDecimal getExRate(PaymentRequestDTO requestDTO) throws IOException {
        if(requestDTO.getCurrency().equals("USD"))
            return BigDecimal.valueOf(1000);
        else
            throw  new IllegalArgumentException("Not suplied");
    }
}
