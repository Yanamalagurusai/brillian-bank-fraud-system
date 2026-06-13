package com.brillian.fraud.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FraudCheckRequest {

    @NotNull(message = "transactionId is required")
    private Long transactionId;

    @NotNull(message = "amount is required")
    @DecimalMin(value = "0.01", message = "amount must be greater than 0")
    private BigDecimal amount;
}
