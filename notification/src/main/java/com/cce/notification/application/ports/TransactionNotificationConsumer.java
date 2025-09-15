package com.cce.notification.application.ports;

import com.cce.notification.domain.entity.TransactionNotificationEntity;

public interface TransactionNotificationConsumer {
    void consume(TransactionNotificationEntity transactionNotificationEntity);
}
