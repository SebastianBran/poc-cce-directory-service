package com.cce.notification.infrastructure.adapters;

import com.cce.notification.application.ports.TransactionNotificationConsumer;
import com.cce.notification.application.ports.TransactionNotificationService;
import com.cce.notification.domain.entity.TransactionNotificationEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class TransactionNotificationConsumerImpl implements TransactionNotificationConsumer {
    private static final Logger logger = LoggerFactory.getLogger(TransactionNotificationConsumerImpl.class);

    private final TransactionNotificationService transactionNotificationService;

    public TransactionNotificationConsumerImpl(TransactionNotificationService transactionNotificationService) {
        this.transactionNotificationService = transactionNotificationService;
    }

    @Override
    @KafkaListener(topics = "transaction-notification-topic", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(TransactionNotificationEntity transactionNotificationEntity) {
        logger.info("Sending transaction notification to {}", transactionNotificationEntity.getSenderEmail());
        transactionNotificationService.send(transactionNotificationEntity);
    }
}
