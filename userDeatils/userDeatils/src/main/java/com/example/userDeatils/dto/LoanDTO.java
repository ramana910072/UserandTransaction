package com.example.userDeatils.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoanDTO {

    private Integer id;
    private Integer loanAmount;
    private Integer loanId;
    private String reason;
}
