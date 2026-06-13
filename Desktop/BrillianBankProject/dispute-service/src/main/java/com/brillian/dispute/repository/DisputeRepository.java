package com.brillian.dispute.repository;

import com.brillian.dispute.entity.Dispute;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisputeRepository extends JpaRepository<Dispute, Long> {
}
