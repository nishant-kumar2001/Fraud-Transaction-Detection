package com.fraud.detection.service;

import com.fraud.detection.kafka.TransactionProducer;
import com.fraud.detection.model.Transaction;
import com.fraud.detection.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;
    private final TransactionProducer transactionProducer;

    public TransactionService(TransactionRepository transactionRepository, TransactionProducer transactionProducer) {
        this.transactionRepository = transactionRepository;
        this.transactionProducer = transactionProducer;
    }

    public Transaction createTransaction(Transaction transaction) {
        Transaction savedTransaction = transactionRepository.save(transaction);
        transactionProducer.sendTransaction(savedTransaction);
        return savedTransaction;
    }

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

}
