package com.brillian.notification.service;

import com.brillian.notification.dto.NotificationResponse;
import com.brillian.notification.entity.Notification;
import com.brillian.notification.repository.NotificationRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private static final Long ADMIN_USER_ID = 0L;

    private final NotificationRepository notificationRepository;
    private final EmailService emailService;

    public NotificationResponse notifyAdmins(String message) {
        Notification notification = Notification.builder()
                .userId(ADMIN_USER_ID)
                .message(message)
                .isRead(false)
                .build();

        Notification savedNotification = notificationRepository.save(notification);
        emailService.sendAdminNotification(message);
        return toResponse(savedNotification);
    }

    public List<NotificationResponse> getAllNotifications() {
        return notificationRepository.findAll().stream()
                .map(this::toResponse)
                .toList();
    }

    public NotificationResponse getNotificationById(Long id) {
        return toResponse(findNotification(id));
    }

    private Notification findNotification(Long id) {
        return notificationRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Notification not found with id: " + id));
    }

    private NotificationResponse toResponse(Notification notification) {
        return NotificationResponse.builder()
                .id(notification.getId())
                .userId(notification.getUserId())
                .message(notification.getMessage())
                .isRead(notification.getIsRead())
                .createdAt(notification.getCreatedAt())
                .build();
    }
}
