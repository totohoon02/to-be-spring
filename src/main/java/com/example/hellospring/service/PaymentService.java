package com.example.hellospring.service;

import com.example.hellospring.domain.ExRateData;
import com.example.hellospring.domain.Payment;
import com.example.hellospring.domain.PaymentRequestDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

@Service
public class PaymentService {
    public Payment prepare(PaymentRequestDTO requestDTO) throws IOException {
        // 환율 가져오기
        URL url = new URL("https://open.er-api.com/v6/latest/" + requestDTO.getCurrency());
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
        String response = br.lines().collect(Collectors.joining());

        br.close();

        ObjectMapper mapper = new ObjectMapper();
        ExRateData data = mapper.readValue(response, ExRateData.class);
        BigDecimal exRate = data.rates().get("KRW");
        System.out.println(exRate);

        // 금액 계산
        BigDecimal convertedAmount = requestDTO.getForeignCurrencyAmount().multiply(exRate);

        // 유효시간
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
