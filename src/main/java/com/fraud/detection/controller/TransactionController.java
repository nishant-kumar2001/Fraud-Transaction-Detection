package com.fraud.detection.controller;

import com.fraud.detection.model.Transaction;
import com.fraud.detection.repository.TransactionRepository;
import com.fraud.detection.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public ResponseEntity<Transaction> createTransaction(@RequestBody Transaction transaction) {
        return ResponseEntity.ok(transactionService.createTransaction(transaction));
    }

    @GetMapping
    public ResponseEntity<List<Transaction>> getAllTransactions() {
        return ResponseEntity.ok(transactionService.getAllTransactions());
    }

    @GetMapping("/fraudulent")
    public List<Transaction> getFraudulentTransactions() {
        return transactionRepository.findByIsFraudulent(true);  // Correct method call
    }

}