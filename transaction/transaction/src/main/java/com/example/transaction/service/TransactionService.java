package com.example.transaction.service;

import com.example.transaction.dto.TransactionDTO;

import java.util.List;

public interface TransactionService {
    TransactionDTO post(TransactionDTO transactionDTO);

    List<TransactionDTO> getAll(Integer userId);

    TransactionDTO update(TransactionDTO transactionDTO);

    TransactionDTO delete(Integer id);
}
