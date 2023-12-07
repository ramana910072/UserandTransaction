package com.example.transaction.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "transaction_details1")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionEntity {


    @Id
    private Integer id;
    private String name;
    private Long amount;
    private Integer userId;
    private String message;
}
