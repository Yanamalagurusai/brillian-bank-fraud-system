package com.brillian.fraud.repository;

import com.brillian.fraud.entity.FraudCase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FraudCaseRepository extends JpaRepository<FraudCase, Long> {
}
