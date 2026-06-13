package com.brillian.fraud.dto;

import com.brillian.fraud.enums.RiskLevel;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class FraudCaseResponse {

    private Long id;
    private Long transactionId;
    private BigDecimal amount;
    private Integer fraudScore;
    private RiskLevel riskLevel;
    private String reason;
    private LocalDateTime createdAt;
}
