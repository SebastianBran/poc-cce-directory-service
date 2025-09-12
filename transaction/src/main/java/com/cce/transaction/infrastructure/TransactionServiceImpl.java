package com.cce.transaction.infrastructure;

import com.cce.transaction.application.ports.TransactionRepository;
import com.cce.transaction.application.ports.TransactionService;
import com.cce.transaction.domain.entity.TransactionEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {
    private static final Logger logger = LoggerFactory.getLogger(TransactionServiceImpl.class);

    private final TransactionRepository transactionRepository;

    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public List<TransactionEntity> getAll() {
        logger.info("Get All Transactions registries");
        return this.transactionRepository.findAll();
    }

    @Override
    public TransactionEntity create(TransactionEntity transactionEntity) {
        logger.info(
                "Create Transaction registry: Sender {} -> Receiver {}",
                transactionEntity.getSenderPhoneNumber(),
                transactionEntity.getReceiverPhoneNumber());
        return this.transactionRepository.save(transactionEntity);
    }
}
