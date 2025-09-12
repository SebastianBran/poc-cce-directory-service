package com.cce.notification.api.controllers;

import com.cce.notification.api.dto.request.CreateNotificationRequest;
import com.cce.notification.application.ports.NotificationService;
import com.cce.notification.domain.entity.NotificationEntity;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/notification")
public class NotificationController {
    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping
    public NotificationEntity create(@Valid @RequestBody CreateNotificationRequest createNotificationRequest) {
        NotificationEntity notificationEntity =
                new NotificationEntity(
                        createNotificationRequest.getSenderEmail(),
                        createNotificationRequest.getReceiverPhoneNumber(),
                        createNotificationRequest.getAmount());
        return this.notificationService.send(notificationEntity);
    }
}
