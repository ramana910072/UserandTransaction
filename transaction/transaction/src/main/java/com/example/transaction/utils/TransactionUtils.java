package com.example.transaction.utils;

import com.example.transaction.dto.TransactionDTO;
import org.apache.commons.lang3.ObjectUtils;

public class TransactionUtils {
    public static String validateTransactionDetails(TransactionDTO transactionDTO){
        if(ObjectUtils.allNull()){
            throw new RuntimeException("Transaction Details Null");
        }
        if(transactionDTO.getUserId()<=0){
            throw new RuntimeException("user id is not null or negative value");
        }
        if(transactionDTO.getId()<=0){
            throw new RuntimeException("Id is not null or negative value");
        }
        if(transactionDTO.getAmount()<=0){
            throw new RuntimeException("Amount is not negative or null value");
        }
        if(transactionDTO.getMessage().length()<=3){
            throw new RuntimeException("String length is not less than three characters");
        }
        if(transactionDTO.getName().length()<=3){
            throw new RuntimeException("Name length is not less than three characters");
        }
        return null;
    }
}
