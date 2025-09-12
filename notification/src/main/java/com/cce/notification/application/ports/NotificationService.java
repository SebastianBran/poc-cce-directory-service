package com.cce.notification.application.ports;

import com.cce.notification.domain.entity.NotificationEntity;

public interface NotificationService {
    NotificationEntity send(NotificationEntity notificationEntity);
}
