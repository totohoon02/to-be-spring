package com.example.hellospring.service;

import com.example.hellospring.domain.Payment;
import com.example.hellospring.domain.PaymentRequestDTO;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public abstract class PaymentService {
    public Payment prepare(PaymentRequestDTO requestDTO) throws IOException {
        BigDecimal exRate = getExRate(requestDTO);
        BigDecimal convertedAmount = requestDTO.getForeignCurrencyAmount().multiply(exRate);
        LocalDateTime validUntil = LocalDateTime.now().plusMinutes(30);

        return Payment.builder()
                .orderId(requestDTO.getOrderId())
                .currency(requestDTO.getCurrency())
                .foreignCurrencyAmount(requestDTO.getForeignCurrencyAmount())
                .exRate(exRate)
                .convertedAmount(convertedAmount)
                .validUntil(validUntil)
                .build();
    }

    abstract BigDecimal getExRate(PaymentRequestDTO requestDTO) throws IOException;


}
