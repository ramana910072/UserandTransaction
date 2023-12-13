package com.example.userDeatils.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "LoanEntity")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoanEntity {

    @Id
    private Integer loanId;
    private Integer loanAmount;
    private Integer id;
    private String reason;
}
