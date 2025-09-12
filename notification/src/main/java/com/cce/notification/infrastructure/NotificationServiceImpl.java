package com.cce.notification.infrastructure;

import com.cce.notification.application.ports.NotificationRepository;
import com.cce.notification.application.ports.NotificationService;
import com.cce.notification.domain.entity.NotificationEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements NotificationService {
    private static final Logger logger = LoggerFactory.getLogger(NotificationServiceImpl.class);

    private final NotificationRepository notificationRepository;

    public NotificationServiceImpl(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @Override
    public NotificationEntity send(NotificationEntity notificationEntity) {
        logger.info("{} send ${} to {}",
                notificationEntity.getSenderEmail(),
                notificationEntity.getAmount(),
                notificationEntity.getReceiverPhoneNumber());
        return notificationRepository.save(notificationEntity);
    }
}
