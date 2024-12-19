package com.example.hellospring.controller;

import com.example.hellospring.controller.docs.PaymentControllerDocs;
import com.example.hellospring.domain.PaymentRequestDTO;
import com.example.hellospring.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class PaymentController implements PaymentControllerDocs {

    private final PaymentService paymentService;

    @PostMapping
    public String payment(@RequestBody PaymentRequestDTO requestDTO) throws IOException {
        return paymentService.prepare(requestDTO).toString();
    }
}
