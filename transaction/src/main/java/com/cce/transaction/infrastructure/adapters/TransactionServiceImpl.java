package com.cce.transaction.infrastructure.adapters;

import com.cce.transaction.api.dto.response.ExistUserInEntityResponseDto;
import com.cce.transaction.application.ports.DirectoryServiceClient;
import com.cce.transaction.application.ports.NotificationService;
import com.cce.transaction.application.ports.TransactionRepository;
import com.cce.transaction.application.ports.TransactionService;
import com.cce.transaction.domain.entity.TransactionEntity;
import com.cce.transaction.domain.entity.TransactionNotificationEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {
    private static final Logger logger = LoggerFactory.getLogger(TransactionServiceImpl.class);

    private final TransactionRepository transactionRepository;
    private final DirectoryServiceClient directoryServiceClient;
    private final NotificationService notificationService;

    public TransactionServiceImpl(
            TransactionRepository transactionRepository,
            DirectoryServiceClient directoryServiceClient,
            NotificationService notificationService) {
        this.transactionRepository = transactionRepository;
        this.directoryServiceClient = directoryServiceClient;
        this.notificationService = notificationService;
    }

    @Override
    public List<TransactionEntity> getAll() {
        logger.info("Get All Transactions registries");
        return this.transactionRepository.findAll();
    }

    @Override
    public TransactionEntity create(TransactionEntity transactionEntity) {
        ExistUserInEntityResponseDto exist = directoryServiceClient
                .userExistInEntity(
                        transactionEntity.getReceiverPhoneNumber(),
                        transactionEntity.getEntityId()
                );

        if (exist.getExist()) {
            logger.info(
                    "Create Transaction registry: Sender {} -> Receiver {}, To Entity -> {}",
                    transactionEntity.getSenderPhoneNumber(),
                    transactionEntity.getReceiverPhoneNumber(),
                    transactionEntity.getEntityId());

            TransactionNotificationEntity transactionNotificationEntity =
                    new TransactionNotificationEntity(
                            transactionEntity.getSenderEmail(),
                            transactionEntity.getReceiverPhoneNumber(),
                            transactionEntity.getAmount()
                    );

            this.notificationService.sendNotification(transactionNotificationEntity);

            return this.transactionRepository.save(transactionEntity);
        }

        logger.info("Receiver user with phone {} not found in entity {}",
                transactionEntity.getReceiverPhoneNumber(),
                transactionEntity.getEntityId());

        throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }
}
