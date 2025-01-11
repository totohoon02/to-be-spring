package com.example.hellospring.provider.inf;

import com.example.hellospring.domain.PaymentRequestDTO;

import java.io.IOException;
import java.math.BigDecimal;

public interface ExRateProvider {
    BigDecimal getExRate(PaymentRequestDTO requestDTO) throws IOException;
}
