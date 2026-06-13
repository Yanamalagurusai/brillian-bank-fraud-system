package com.brillian.notification.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EmailService {

    public void sendAdminNotification(String message) {
        log.info("Admin notification email queued: {}", message);
    }
}
