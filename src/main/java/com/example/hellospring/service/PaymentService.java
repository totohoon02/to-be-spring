package com.example.hellospring.service;

import com.example.hellospring.domain.Payment;
import com.example.hellospring.domain.PaymentRequestDTO;
import com.example.hellospring.provider.inf.ExRateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final ExRateService exRateService;

    public Payment prepare(PaymentRequestDTO requestDTO) throws IOException {
        BigDecimal exRate = exRateService.getExRate(requestDTO);
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



}
