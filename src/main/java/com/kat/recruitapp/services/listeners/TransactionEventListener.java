package com.kat.recruitapp.services.listeners;

import com.kat.recruitapp.dtos.TransactionEvent;
import com.kat.recruitapp.services.TransactionMessageService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionalEventListener;

import java.util.concurrent.CompletableFuture;

@Service
public class TransactionEventListener {

    private final TransactionMessageService transactionMessageService;

    public TransactionEventListener(TransactionMessageService transactionMessageService) {
        this.transactionMessageService = transactionMessageService;
    }

    @TransactionalEventListener
    public void handleTransferCompletedEvent(TransactionEvent event) {
        CompletableFuture.runAsync(() -> sendNotification(event));
    }

    private void sendNotification(TransactionEvent event) {
        transactionMessageService.sendInformationAboutTransaction(event.getUserEntity(), event.getTransactionDto().toString());
    }
}
