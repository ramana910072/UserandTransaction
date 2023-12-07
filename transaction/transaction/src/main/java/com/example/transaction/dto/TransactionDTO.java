package com.example.transaction.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDTO {

    private Integer id;
    private String name;
    private Long amount;
    private Integer userId;
    private String message;

    public TransactionDTO(Integer id, String name, String message, Long amount, Integer userId) {
        this.id =id;
        this.name = name;
        this.message =message;
        this.amount =amount;
        this.userId = userId;
    }
}
