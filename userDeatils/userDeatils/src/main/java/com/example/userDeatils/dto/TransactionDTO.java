package com.example.userDeatils.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDTO {

    private Integer id;
    private String name;
    private String message;
    private Long amount;
    private Integer userId;
}
