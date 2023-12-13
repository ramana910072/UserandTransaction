package com.example.transaction.utils;

import com.example.transaction.dto.TransactionDTO;
import com.example.transaction.exception.ResourceNotFoundException;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Component;

public class TransactionStaticUtils {
    public  static String validateTransactionDetails(TransactionDTO transactionDTO){
        if(ObjectUtils.anyNull()){
            throw new ResourceNotFoundException("Transaction Details Null");
        }
        if(transactionDTO.getUserId()<=0){
            throw new ResourceNotFoundException("user id is not null or negative value");
        }
        if(transactionDTO.getId()<=0){
            throw new ResourceNotFoundException("Id is not null or negative value");
        }
        if(transactionDTO.getAmount()<=0){
            throw new ResourceNotFoundException("Amount is not negative or null value");
        }
        if(transactionDTO.getMessage().length()<=3){
            throw new ResourceNotFoundException("String length is not less than three characters");
        }
        if(transactionDTO.getName().length()<=3){
            throw new ResourceNotFoundException("Name length is not less than three characters");
        }
        return null;
    }
}
