package com.example.userDeatils.service;

import com.example.userDeatils.dao.LoanDAO;
import com.example.userDeatils.dao.UserDAO;
import com.example.userDeatils.dto.LoanDTO;
import com.example.userDeatils.dto.TransactionDTO;
import com.example.userDeatils.dto.UesrDtoPojo;
import com.example.userDeatils.dto.UserDTO;
import com.example.userDeatils.entity.LoanEntity;
import com.example.userDeatils.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImple implements UserService {

    private final UserDAO userDAO;
    private final LoanDAO loanDAO;
    private final RestTemplate restTemplate;
/*    @Override
    public UesrDtoPojo postUser(UesrDtoPojo uesrDtoPojo) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(uesrDtoPojo.getId());
        userEntity.setName(uesrDtoPojo.getName());
        userDAO.save(userEntity);
        return uesrDtoPojo;
    } */
    @Override
    public UserDTO postUser(UserDTO uesrDto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(uesrDto.getId());
        userEntity.setName(uesrDto.getName());
        userDAO.save(userEntity);
        return uesrDto;
    }

    @Override
    public UserDTO getUser(Integer id) {
        List<TransactionDTO> transactionDTOList = restTemplate.getForObject("http://localhost:8082/transaction/get/{userid}",List.class,id);
        Optional<UserEntity> userEntity = userDAO.findById(id);
        UserDTO userDTO = new UserDTO();
        UserEntity userEntity1 = userEntity.get();
        userDTO.setId(userEntity1.getId());
        userDTO.setName(userEntity1.getName());

        List<LoanEntity>loanEntities = loanDAO.findAllById(id);
        List<LoanDTO>loanDTOList = new ArrayList<>();
        for(LoanEntity loanEntity:loanEntities){
            LoanDTO loanDTO = new LoanDTO();
            loanDTO.setId(loanEntity.getId());
            loanDTO.setLoanAmount(loanEntity.getLoanAmount());
            loanDTO.setLoanId(loanEntity.getLoanId());
            loanDTO.setReason(loanEntity.getReason());
            loanDTOList.add(loanDTO);
        }

        return new UserDTO(userEntity1.getId(),userEntity1.getName(),transactionDTOList,loanDTOList);

    }

    @Override
    public UserDTO updateUser(UserDTO userDTO) {
        return null;
    }
}
