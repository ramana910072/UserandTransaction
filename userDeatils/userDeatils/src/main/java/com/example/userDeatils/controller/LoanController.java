package com.example.userDeatils.controller;

import com.example.userDeatils.dto.LoanDTO;
import com.example.userDeatils.dto.UserDTO;
import com.example.userDeatils.service.LoanService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/loan")
public class LoanController {

    private final LoanService loanService;

    @Operation(summary = "Post Data to the Loans")
    @ApiResponse(responseCode = "200",description = "List of Loans added")
    @ApiResponse(responseCode = "204",description = "Loans not added")

    @PostMapping("/post")
    public ResponseEntity<LoanDTO>post(@RequestBody LoanDTO loanDTO){
      return new ResponseEntity<>(loanService.post(loanDTO),HttpStatus.OK);
    }

    @Operation(summary = "Adding data to the Loans Object")
    @ApiResponse(responseCode = "200",description = "Return List of Loans Objects")
    @ApiResponse(responseCode = "204",description = "not Returning Loans Objects")

    @GetMapping("/get/{id}")
    public ResponseEntity<List<LoanDTO>>getall(@PathVariable Integer id){
        return new ResponseEntity<>(loanService.getall(id),HttpStatus.OK);
    }

    @GetMapping("/update")
    public ResponseEntity<LoanDTO>update(@RequestBody LoanDTO loanDTO){
        return new ResponseEntity<>(loanService.update(loanDTO),HttpStatus.OK);
    }


}
