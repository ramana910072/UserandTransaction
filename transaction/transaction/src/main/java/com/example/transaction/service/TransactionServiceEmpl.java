package com.example.transaction.service;

import com.example.transaction.dao.TransactionDAO;
import com.example.transaction.dto.TransactionDTO;
import com.example.transaction.entity.TransactionEntity;
import com.example.transaction.exception.ResourceNotFoundException;
import com.example.transaction.utils.TransactionStaticUtils;
import com.example.transaction.utils.TransactionUtils;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TransactionServiceEmpl implements TransactionService{

    private final TransactionDAO transactionDAO;
    private final TransactionUtils transactionUtils;
    @Override
    public TransactionDTO post(TransactionDTO transactionDTO) {
        try {
            transactionUtils.validateTransactionDetails(transactionDTO);
            if(transactionDAO.existsById(transactionDTO.getId())){
                throw new ResourceNotFoundException("Already exists this Id");
            }
            else {
                TransactionEntity transactionEntity = new TransactionEntity();
                transactionEntity.setId(transactionDTO.getId());
                transactionEntity.setName(transactionDTO.getName());
                transactionEntity.setAmount(transactionDTO.getAmount());
                transactionEntity.setUserId(transactionDTO.getUserId());
                transactionEntity.setMessage(transactionDTO.getMessage());
                transactionDAO.save(transactionEntity);
            }
        }
        catch (ResourceNotFoundException exception) {
            throw exception;
        }
        return transactionDTO;
    }
    @Override
    public List<TransactionDTO> getAll(Integer userId) {
        List<TransactionEntity> transactionEntity = transactionDAO.findAllByUserId(userId);
        List<TransactionDTO> transactionDTO =new ArrayList<>();
        for(TransactionEntity transactionEntity1:transactionEntity){
            TransactionDTO transactionDTO1 =new TransactionDTO();
            transactionDTO1.setId(transactionEntity1.getId());
            transactionDTO1.setName(transactionEntity1.getName());
            transactionDTO1.setAmount(transactionEntity1.getAmount());
            transactionDTO1.setUserId(transactionEntity1.getUserId());
            transactionDTO1.setMessage(transactionEntity1.getMessage());
            transactionDTO.add(transactionDTO1);
        }
        return transactionDTO;
    }
    @Override
    public TransactionDTO update(TransactionDTO transactionDTO) {
        transactionUtils.validateTransactionDetails(transactionDTO);
        TransactionStaticUtils.validateTransactionDetails(transactionDTO);
        Optional<TransactionEntity> transactionEntity = transactionDAO.findById(transactionDTO.getId());

        TransactionEntity transactionEntity1 = transactionEntity.get();
        if(StringUtils.isNotEmpty(transactionDTO.getName())) {
            transactionEntity1.setName(transactionDTO.getName());
        }
        if(StringUtils.isNotEmpty(transactionDTO.getMessage())){
            transactionEntity1.setMessage(transactionDTO.getMessage());
        }
        if(transactionDTO.getAmount()!= null){
            transactionEntity1.setAmount(transactionDTO.getAmount());
        }
        if(transactionDTO.getUserId()!= null){
            transactionEntity1.setUserId(transactionDTO.getUserId());
        }
        transactionEntity1 = transactionDAO.saveAndFlush(transactionEntity1);
        return new TransactionDTO(transactionEntity1.getId(),transactionEntity1.getName(),transactionEntity1.getAmount(),transactionEntity1.getUserId(),transactionEntity1.getMessage());
    }
    @Override
    public TransactionDTO delete(Integer id) {
        return null;
    }
}
