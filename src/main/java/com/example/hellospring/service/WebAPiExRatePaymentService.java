package com.example.hellospring.service;

import com.example.hellospring.domain.ExRateData;
import com.example.hellospring.domain.PaymentRequestDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.stream.Collectors;

public class WebAPiExRatePaymentService extends PaymentService {
    @Override
    BigDecimal getExRate(PaymentRequestDTO requestDTO) throws IOException {
        URL url = new URL("https://open.er-api.com/v6/latest/" + requestDTO.getCurrency());
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
        String response = br.lines().collect(Collectors.joining());
        br.close();

        ObjectMapper mapper = new ObjectMapper();
        ExRateData data = mapper.readValue(response, ExRateData.class);
        return data.rates().get("KRW");
    }
}
