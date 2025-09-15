package com.cce.transaction.application.ports;

import com.cce.transaction.domain.entity.TransactionNotificationEntity;

public interface NotificationService {
    void sendNotification(TransactionNotificationEntity transactionNotificationEntity);
}
