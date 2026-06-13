package com.brillian.fraud.service;

import com.brillian.fraud.dto.FraudCaseResponse;
import com.brillian.fraud.dto.FraudCheckRequest;
import com.brillian.fraud.entity.FraudCase;
import com.brillian.fraud.enums.RiskLevel;
import com.brillian.fraud.repository.FraudCaseRepository;
import java.math.BigDecimal;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FraudDetectionService {

    private static final BigDecimal MEDIUM_RISK_MINIMUM = new BigDecimal("10000");
    private static final BigDecimal HIGH_RISK_MINIMUM = new BigDecimal("50000");

    private final FraudCaseRepository fraudCaseRepository;

    public FraudCaseResponse checkFraud(FraudCheckRequest request) {
        RiskLevel riskLevel = calculateRiskLevel(request.getAmount());

        FraudCase fraudCase = FraudCase.builder()
                .transactionId(request.getTransactionId())
                .amount(request.getAmount())
                .fraudScore(calculateFraudScore(riskLevel))
                .riskLevel(riskLevel)
                .reason(buildReason(riskLevel))
                .build();

        return toResponse(fraudCaseRepository.save(fraudCase));
    }

    public List<FraudCaseResponse> getAllFraudCases() {
        return fraudCaseRepository.findAll().stream()
                .map(this::toResponse)
                .toList();
    }

    public FraudCaseResponse getFraudCaseById(Long id) {
        return toResponse(findFraudCase(id));
    }

    private FraudCase findFraudCase(Long id) {
        return fraudCaseRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Fraud case not found with id: " + id));
    }

    private RiskLevel calculateRiskLevel(BigDecimal amount) {
        if (amount.compareTo(HIGH_RISK_MINIMUM) > 0) {
            return RiskLevel.HIGH;
        }
        if (amount.compareTo(MEDIUM_RISK_MINIMUM) >= 0) {
            return RiskLevel.MEDIUM;
        }
        return RiskLevel.LOW;
    }

    private Integer calculateFraudScore(RiskLevel riskLevel) {
        return switch (riskLevel) {
            case HIGH -> 90;
            case MEDIUM -> 60;
            case LOW -> 25;
        };
    }

    private String buildReason(RiskLevel riskLevel) {
        return switch (riskLevel) {
            case HIGH -> "Transaction amount is greater than 50000";
            case MEDIUM -> "Transaction amount is between 10000 and 50000";
            case LOW -> "Transaction amount is below 10000";
        };
    }

    private FraudCaseResponse toResponse(FraudCase fraudCase) {
        return FraudCaseResponse.builder()
                .id(fraudCase.getId())
                .transactionId(fraudCase.getTransactionId())
                .amount(fraudCase.getAmount())
                .fraudScore(fraudCase.getFraudScore())
                .riskLevel(fraudCase.getRiskLevel())
                .reason(fraudCase.getReason())
                .createdAt(fraudCase.getCreatedAt())
                .build();
    }
}
