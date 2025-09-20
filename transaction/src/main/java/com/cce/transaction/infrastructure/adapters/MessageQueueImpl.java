package com.cce.transaction.infrastructure.adapters;

import com.cce.transaction.application.ports.MessageQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageQueueImpl implements MessageQueue {
    private static final Logger logger = LoggerFactory.getLogger(MessageQueueImpl.class);
    private final JmsTemplate jmsTemplate;

    @Value("${app.mq.queueOut}")
    private String queueOut;

    public MessageQueueImpl(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @Override
    public void sendMessage(String message) {
        logger.info("Sending message to queue {}: {}", queueOut, message);
        jmsTemplate.convertAndSend(queueOut, message);
        logger.info("Message sent successfully");
    }
}
