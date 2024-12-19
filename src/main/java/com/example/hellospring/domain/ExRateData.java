package com.example.hellospring.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;
import java.util.Map;

// 없는거 무시해
@JsonIgnoreProperties(ignoreUnknown = true)
public record ExRateData(String result, Map<String, BigDecimal> rates) {
    // record : parameter에 이름으로 정의하면 생성자랑 알아서 해줌
}
