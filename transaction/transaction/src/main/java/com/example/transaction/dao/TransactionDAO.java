package com.example.transaction.dao;


import com.example.transaction.entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionDAO extends JpaRepository<TransactionEntity,Integer> {
     //List<TransactionEntity> findAllById(Integer id);

     List<TransactionEntity> findAllByUserId(Integer userId);
}
