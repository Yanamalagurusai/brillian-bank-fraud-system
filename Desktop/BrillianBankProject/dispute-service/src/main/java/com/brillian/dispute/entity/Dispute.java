package com.brillian.dispute.entity;

import com.brillian.dispute.enums.DisputeStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "disputes")
public class Dispute {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long transactionId;

    @Column(nullable = false, precision = 19, scale = 2)
    private BigDecimal amount;

    @Column(nullable = false, length = 500)
    private String reason;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private DisputeStatus status;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    void prePersist() {
        if (status == null) {
            status = DisputeStatus.OPEN;
        }
        if (createdAt == null) {
            createdAt = LocalDateTime.now();
        }
    }
}
