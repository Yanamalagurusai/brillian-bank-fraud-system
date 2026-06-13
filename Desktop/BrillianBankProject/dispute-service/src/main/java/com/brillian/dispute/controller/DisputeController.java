package com.brillian.dispute.controller;

import com.brillian.dispute.dto.CreateDisputeRequest;
import com.brillian.dispute.dto.DisputeResponse;
import com.brillian.dispute.dto.UpdateDisputeStatusRequest;
import com.brillian.dispute.service.DisputeService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/disputes")
@RequiredArgsConstructor
public class DisputeController {

    private final DisputeService disputeService;

    @PostMapping
    public ResponseEntity<DisputeResponse> createDispute(@Valid @RequestBody CreateDisputeRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(disputeService.createDispute(request));
    }

    @GetMapping
    public ResponseEntity<List<DisputeResponse>> getAllDisputes() {
        return ResponseEntity.ok(disputeService.getAllDisputes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisputeResponse> getDisputeById(@PathVariable Long id) {
        return ResponseEntity.ok(disputeService.getDisputeById(id));
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<DisputeResponse> updateDisputeStatus(
            @PathVariable Long id,
            @Valid @RequestBody UpdateDisputeStatusRequest request) {
        return ResponseEntity.ok(disputeService.updateDisputeStatus(id, request));
    }
}
