package com.example.hellospring.service;

import com.example.hellospring.domain.Payment;
import com.example.hellospring.domain.PaymentRequestDTO;
import com.example.hellospring.provider.WebAPiExRateProvider;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
class PaymentServiceTest {

    @Test
    @DisplayName("preare method가 요구사항을 충족하는지")
    void prepare() throws IOException {
        PaymentService paymentService = new PaymentService(new WebAPiExRateProvider());
        PaymentRequestDTO paymentRequestDTO = new PaymentRequestDTO(1L, "USD", BigDecimal.TEN);

        Payment payment = paymentService.prepare(paymentRequestDTO);

        // 환율 정보
        assertThat(payment.getExRate()).isNotNull();

        // 원화 계산
        assertThat(payment.getConvertedAmount())
                .isEqualTo(payment.getExRate().multiply(payment.getForeignCurrencyAmount()));

        // 유효시간
        assertThat(payment.getValidUntil()).isAfter(LocalDateTime.now());
    }
}