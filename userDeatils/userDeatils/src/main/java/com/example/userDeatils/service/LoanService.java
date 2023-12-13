package com.example.userDeatils.service;

import com.example.userDeatils.dto.LoanDTO;

import java.util.List;

public interface LoanService {
     LoanDTO post(LoanDTO loanDTO);

     List<LoanDTO> getall(Integer id);

     LoanDTO update(LoanDTO loanDTO);
}
