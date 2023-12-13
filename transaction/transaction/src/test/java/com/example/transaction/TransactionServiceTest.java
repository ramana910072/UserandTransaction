package com.example.transaction;

import com.example.transaction.dao.TransactionDAO;
import com.example.transaction.dto.TransactionDTO;
import com.example.transaction.entity.TransactionEntity;
import com.example.transaction.service.TransactionService;
import com.example.transaction.utils.TransactionStaticUtils;
import com.example.transaction.utils.TransactionUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

@SpringBootTest
class TransactionServiceTest {

    @Autowired
    private TransactionService transactionService;
    @MockBean

    private TransactionDAO transactionDAO;
    TransactionDTO transactionDTO;
    TransactionEntity transactionEntity;

    @MockBean
    TransactionUtils transactionUtils;
    @BeforeEach
    void insertData() {
        transactionDTO = new TransactionDTO();
        transactionDTO.setId(1);
        transactionDTO.setName("ABC");
        transactionEntity = new TransactionEntity();
        BeanUtils.copyProperties(transactionDTO, transactionEntity);
    }
    @Test
    void getAllTransactionTest() {
        List<TransactionEntity> transactionEntities = new ArrayList<>();
        transactionEntities.add(transactionEntity);
        List<TransactionDTO> transactionDTOS = new ArrayList<>();
        transactionDTOS.add(transactionDTO);
        when(transactionDAO.findAllByUserId(2)).thenReturn(transactionEntities);
        List<TransactionDTO> transactionDTOList = transactionService.getAll(2);
        assertEquals(transactionDTOS, transactionDTOList);
    }
    @Test
    void updateTransaction() {
        when(transactionUtils.validateTransactionDetails(transactionDTO)).thenReturn(null);
        mockStatic(TransactionStaticUtils.class);
        when(TransactionStaticUtils.validateTransactionDetails(transactionDTO)).thenReturn(null);
        when(transactionDAO.findById(1)).thenReturn(Optional.of(transactionEntity));

        when(transactionDAO.saveAndFlush(transactionEntity)).thenReturn(transactionEntity);

        TransactionDTO transactionDTO1 = transactionService.update(transactionDTO);
        assertEquals(transactionDTO, transactionDTO1);
    }
}
