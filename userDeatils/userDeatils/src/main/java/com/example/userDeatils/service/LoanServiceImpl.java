package com.example.userDeatils.service;

import com.example.userDeatils.dao.LoanDAO;
import com.example.userDeatils.dto.LoanDTO;
import com.example.userDeatils.entity.LoanEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LoanServiceImpl implements LoanService {
    private final LoanDAO loanDAO;
    @Override
    public LoanDTO post(LoanDTO loanDTO) {
        LoanEntity loanEntity = new LoanEntity();
        loanEntity.setId(loanDTO.getId());
        loanEntity.setLoanAmount(loanDTO.getLoanAmount());
        loanEntity.setLoanId(loanDTO.getLoanId());
        loanEntity.setReason(loanDTO.getReason());
        loanDAO.save(loanEntity);
        return loanDTO;
    }

    @Override
    public List<LoanDTO> getall(Integer loanId) {
        List<LoanEntity>loanEntities = loanDAO.findAllById(loanId);
        List<LoanDTO>loanDTOList = new ArrayList<>();
        for(LoanEntity loanEntity:loanEntities){
            LoanDTO loanDTO = new LoanDTO();
            loanDTO.setId(loanEntity.getId());
            loanDTO.setLoanAmount(loanEntity.getLoanAmount());
            loanDTO.setLoanId(loanEntity.getLoanId());
            loanDTO.setReason(loanEntity.getReason());
            loanDTOList.add(loanDTO);
        }
    return loanDTOList;
    }

    @Override
    public LoanDTO update(LoanDTO loanDTO) {
        return null;
    }
}
