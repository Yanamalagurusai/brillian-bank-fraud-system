package com.brillian.notification.repository;

import com.brillian.notification.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
