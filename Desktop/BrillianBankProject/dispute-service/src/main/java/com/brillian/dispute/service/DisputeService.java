package com.brillian.dispute.service;

import com.brillian.dispute.dto.CreateDisputeRequest;
import com.brillian.dispute.dto.DisputeResponse;
import com.brillian.dispute.dto.UpdateDisputeStatusRequest;
import com.brillian.dispute.entity.Dispute;
import com.brillian.dispute.enums.DisputeStatus;
import com.brillian.dispute.repository.DisputeRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DisputeService {

    private final DisputeRepository disputeRepository;

    public DisputeResponse createDispute(CreateDisputeRequest request) {
        Dispute dispute = Dispute.builder()
                .transactionId(request.getTransactionId())
                .amount(request.getAmount())
                .reason(request.getReason())
                .status(DisputeStatus.OPEN)
                .build();

        return toResponse(disputeRepository.save(dispute));
    }

    public List<DisputeResponse> getAllDisputes() {
        return disputeRepository.findAll().stream()
                .map(this::toResponse)
                .toList();
    }

    public DisputeResponse getDisputeById(Long id) {
        return toResponse(findDispute(id));
    }

    public DisputeResponse updateDisputeStatus(Long id, UpdateDisputeStatusRequest request) {
        Dispute dispute = findDispute(id);
        dispute.setStatus(request.getStatus());
        return toResponse(disputeRepository.save(dispute));
    }

    private Dispute findDispute(Long id) {
        return disputeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Dispute not found with id: " + id));
    }

    private DisputeResponse toResponse(Dispute dispute) {
        return DisputeResponse.builder()
                .id(dispute.getId())
                .transactionId(dispute.getTransactionId())
                .amount(dispute.getAmount())
                .reason(dispute.getReason())
                .status(dispute.getStatus())
                .createdAt(dispute.getCreatedAt())
                .build();
    }
}
