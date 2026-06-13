package com.brillian.dispute.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateDisputeRequest {

    @NotNull(message = "transactionId is required")
    private Long transactionId;

    @NotNull(message = "amount is required")
    @DecimalMin(value = "0.01", message = "amount must be greater than 0")
    private BigDecimal amount;

    @NotBlank(message = "reason is required")
    @Size(max = 500, message = "reason must not exceed 500 characters")
    private String reason;
}
