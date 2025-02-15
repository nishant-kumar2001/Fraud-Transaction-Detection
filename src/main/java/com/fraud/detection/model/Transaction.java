package com.fraud.detection.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
//import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
//@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private UUID userId;
    private BigDecimal amount;
    private LocalDateTime timestamp;
    private String status;

    @Column(nullable = false)
    private boolean isFraudulent;

    public Transaction() {
        this.timestamp = LocalDateTime.now();
        this.status = "PENDING";
    }

    // Getters and Setters
}
