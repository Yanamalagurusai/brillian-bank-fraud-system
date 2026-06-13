package com.brillian.fraud.controller;

import com.brillian.fraud.dto.FraudCaseResponse;
import com.brillian.fraud.dto.FraudCheckRequest;
import com.brillian.fraud.service.FraudDetectionService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/fraud")
@RequiredArgsConstructor
public class FraudController {

    private final FraudDetectionService fraudDetectionService;

    @PostMapping("/check")
    public ResponseEntity<FraudCaseResponse> checkFraud(@Valid @RequestBody FraudCheckRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(fraudDetectionService.checkFraud(request));
    }

    @GetMapping
    public ResponseEntity<List<FraudCaseResponse>> getAllFraudCases() {
        return ResponseEntity.ok(fraudDetectionService.getAllFraudCases());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FraudCaseResponse> getFraudCaseById(@PathVariable Long id) {
        return ResponseEntity.ok(fraudDetectionService.getFraudCaseById(id));
    }
}
