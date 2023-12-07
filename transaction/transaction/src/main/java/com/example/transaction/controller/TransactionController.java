package com.example.transaction.controller;

import com.example.transaction.dto.TransactionDTO;
import com.example.transaction.service.TransactionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction")

public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @Operation(summary = "Post Data to the Transaction")
    @ApiResponse(responseCode = "200",description = "List of Transactions added")
    @ApiResponse(responseCode = "204",description = "Transactions not added")
    @PostMapping("/post")
    public ResponseEntity<TransactionDTO> post(@RequestBody TransactionDTO transactionDTO){

        TransactionDTO transactionDTO1= transactionService.post(transactionDTO);
        if (ObjectUtils.isNotEmpty(transactionDTO1))
         return new ResponseEntity<>(transactionDTO1, HttpStatus.OK);
        else
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);

    }
    @Operation(summary = "Adding data to the Transaction Object")
    @ApiResponse(responseCode = "200",description = "Return List of Transaction Objects")
    @ApiResponse(responseCode = "204",description = "not Returning Transaction Objects")
    //localhost:8080/transaction/get/{id}
    @GetMapping("/get/{userId}")
    public ResponseEntity<List<TransactionDTO>>getAll(@PathVariable Integer userId){

        return new ResponseEntity<>(transactionService.getAll(userId),HttpStatus.OK);
    }
    @Operation(summary = "Updating data to the Transaction Object")
    @ApiResponse(responseCode = "200",description = "Updated List of Transaction Objects")
    @ApiResponse(responseCode = "204",description = "not Updating Transaction Objects")
    @PutMapping("/update")
    public ResponseEntity<TransactionDTO> update(@RequestBody TransactionDTO transactionDTO){
        return new ResponseEntity<>(transactionService.update(transactionDTO),HttpStatus.OK);
    }
    @DeleteMapping("/delete{id}")
    public TransactionDTO delete(@PathVariable Integer id){
        return transactionService.delete(id);
    }
}
