package com.brillian.notification.dto;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class NotificationResponse {

    private Long id;
    private Long userId;
    private String message;
    private Boolean isRead;
    private LocalDateTime createdAt;
}
