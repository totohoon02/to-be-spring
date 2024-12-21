package com.example.hellospring.service;

import com.example.hellospring.domain.PaymentRequestDTO;

import java.io.IOException;
import java.math.BigDecimal;

public class SimpleExRatePaymentService extends PaymentService{
    @Override
    BigDecimal getExRate(PaymentRequestDTO requestDTO) throws IOException {
        if(requestDTO.getCurrency().equals("USD"))
            return BigDecimal.valueOf(1000);
        else
            throw  new IllegalArgumentException("Not suplied");
    }
}
