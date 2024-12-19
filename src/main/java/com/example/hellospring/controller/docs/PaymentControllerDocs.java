package com.example.hellospring.controller.docs;

import com.example.hellospring.domain.PaymentRequestDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.io.IOException;

@Tag(name = "PaymentController", description = "")
public interface PaymentControllerDocs {
	@Operation(summary = "payment", description = "payment REPL")
	String payment(@RequestBody PaymentRequestDTO requestDTO) throws IOException;

}