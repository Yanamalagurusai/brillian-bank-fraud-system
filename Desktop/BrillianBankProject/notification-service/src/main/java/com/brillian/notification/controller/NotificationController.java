package com.brillian.notification.controller;

import com.brillian.notification.dto.NotificationResponse;
import com.brillian.notification.service.NotificationService;
import jakarta.validation.constraints.NotBlank;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("/api/notifications")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationService notificationService;

    @PostMapping("/admins")
    public ResponseEntity<NotificationResponse> notifyAdmins(
            @RequestParam @NotBlank(message = "message is required") String message) {
        return ResponseEntity.status(HttpStatus.CREATED).body(notificationService.notifyAdmins(message));
    }

    @GetMapping
    public ResponseEntity<List<NotificationResponse>> getAllNotifications() {
        return ResponseEntity.ok(notificationService.getAllNotifications());
    }

    @GetMapping("/{id}")
    public ResponseEntity<NotificationResponse> getNotificationById(@PathVariable Long id) {
        return ResponseEntity.ok(notificationService.getNotificationById(id));
    }
}
