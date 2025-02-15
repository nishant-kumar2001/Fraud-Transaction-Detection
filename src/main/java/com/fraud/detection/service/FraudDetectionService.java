package com.fraud.detection.service;

import com.fraud.detection.model.Transaction;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class FraudDetectionService {

    @KafkaListener(topics = "transactions", groupId = "fraud-group")
    public void consumeTransaction(Transaction transaction) {
        System.out.println("Received Transaction: " + transaction);

        // TODO: Implement fraud detection logic
        boolean isFraudulent = detectFraud(transaction);

        if (isFraudulent) {
            System.out.println("🚨 Fraudulent Transaction Detected! " + transaction);
            // Send alert or take action
        } else {
            System.out.println("✅ Transaction is safe: " + transaction);
        }
    }

    private boolean detectFraud(Transaction transaction) {
        // Simple rule-based fraud detection (for now)

        return transaction.getAmount().compareTo(new BigDecimal("5000")) > 0; // Flag transactions above ₹5000
    }
}
