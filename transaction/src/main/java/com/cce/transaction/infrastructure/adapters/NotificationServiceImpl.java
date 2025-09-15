package com.cce.transaction.infrastructure.adapters;

import com.cce.transaction.application.ports.NotificationService;
import com.cce.transaction.domain.entity.TransactionNotificationEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
public class NotificationServiceImpl implements NotificationService {
    private static final Logger logger = LoggerFactory.getLogger(NotificationServiceImpl.class);

    private final KafkaTemplate<String, TransactionNotificationEntity> kafkaTemplate;

    public NotificationServiceImpl(KafkaTemplate<String, TransactionNotificationEntity> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void sendNotification(TransactionNotificationEntity transactionNotificationEntity) {
        logger.info("Send transaction notification to {}", transactionNotificationEntity.getSenderEmail());
        kafkaTemplate.send("transaction-notification-topic", transactionNotificationEntity);
    }
}
