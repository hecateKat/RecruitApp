package com.kat.recruitapp.services.Impl;

import com.kat.recruitapp.dtos.TransactionDto;
import com.kat.recruitapp.dtos.TransactionEvent;
import com.kat.recruitapp.dtos.TransactionRequest;
import com.kat.recruitapp.entities.BalanceEntity;
import com.kat.recruitapp.entities.TransactionEntity;
import com.kat.recruitapp.entities.UserEntity;
import com.kat.recruitapp.exceptions.NoFundsException;
import com.kat.recruitapp.exceptions.TransactionLimitException;
import com.kat.recruitapp.mappers.TransactionMapper;
import com.kat.recruitapp.repositories.BalanceRepository;
import com.kat.recruitapp.repositories.TransactionRepository;
import com.kat.recruitapp.repositories.UserRepository;
import com.kat.recruitapp.services.TransactionService;
import com.kat.recruitapp.services.UserCredentialsService;
import com.kat.recruitapp.statics.StaticValues;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final BalanceRepository balanceRepository;
    private final UserRepository userRepository;

    private final UserCredentialsService userCredentialsService;

    private ApplicationEventPublisher publisher;

    public TransactionServiceImpl(TransactionRepository transactionRepository, BalanceRepository balanceRepository, UserRepository userRepository, UserCredentialsService userCredentialsService, ApplicationEventPublisher publisher) {
        this.transactionRepository = transactionRepository;
        this.balanceRepository = balanceRepository;
        this.userRepository = userRepository;
        this.userCredentialsService = userCredentialsService;
        this.publisher = publisher;
    }


    @Override
    @Transactional
    public TransactionDto createTransaction(TransactionRequest request) {
        BigDecimal amount = request.getAmount();
        String username = userCredentialsService.getAuthenticatedCredentialUsername();
        BalanceEntity balanceEntity = balanceRepository.getUserBalanceByUsername(username).get();

        checkBalance(balanceEntity, amount);
        validateDailyTransfers(balanceEntity.getBalanceId());

        BalanceEntity balanceById = balanceRepository.getUserBalanceByBalanceId(request.getRecipient()).get();
        balanceEntity.setAmount(balanceEntity.getAmount().subtract(amount));
        balanceById.setAmount(balanceById.getAmount().add(amount));

        TransactionEntity transaction = createTransaction(amount, balanceEntity.getBalanceId(), balanceById.getBalanceId());
        transactionRepository.save(transaction);
        TransactionDto transactionDto = TransactionMapper.mapToDto(transaction);
        UserEntity userEntityByUsername = userRepository.getUserEntityByUsername(username).get();
        TransactionEvent event = createEvent(transactionDto, userEntityByUsername);
        publisher.publishEvent(event);

        return transactionDto;
    }

    private void checkBalance(BalanceEntity balanceEntity, BigDecimal amount) {
        if (balanceEntity.getAmount().subtract(amount).intValue() < 0) {
            throw new NoFundsException("Not enough balance in account");
        }
    }

    private void validateDailyTransfers(String id) {
        LocalDateTime localDateTime = LocalDate.now().atStartOfDay();
        int transactions = transactionRepository.countTransactionEntitiesBySenderAndTransactionTimeBetween(id, localDateTime, LocalDateTime.now());

        if (transactions >= StaticValues.DAILY_TRANSACTION_LIMIT) {
            throw new TransactionLimitException("You have reached the limit of transactions for one day");
        }
    }

    private TransactionEntity createTransaction(BigDecimal amount, String sender, String recipient){
        TransactionEntity transaction = TransactionEntity.builder()
                .amount(amount)
                .transactionTime(LocalDateTime.now())
                .sender(sender)
                .recipient(recipient)
                .build();
        return transaction;
    }

    private TransactionEvent createEvent(TransactionDto transactionDto, UserEntity userEntity){
        TransactionEvent event = TransactionEvent.builder()
                .transactionDto(transactionDto)
                .userEntity(userEntity)
                .build();
        return event;
    }

}
