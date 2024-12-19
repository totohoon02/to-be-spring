package com.example.hellospring.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class PaymentRequestDTO {
    @Schema(description = "주문 ID", example = "100")
    private Long orderId;
    @Schema(description = "통화 종류", example = "USD")
    private String currency;
    @Schema(description = "통화 환산 값", example = "50.7")
    private BigDecimal foreignCurrencyAmount;
}
