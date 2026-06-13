package com.brillian.dispute.dto;

import com.brillian.dispute.enums.DisputeStatus;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class DisputeResponse {

    private Long id;
    private Long transactionId;
    private BigDecimal amount;
    private String reason;
    private DisputeStatus status;
    private LocalDateTime createdAt;
}
