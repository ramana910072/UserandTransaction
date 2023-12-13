package com.example.userDeatils.dao;

import com.example.userDeatils.entity.LoanEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoanDAO extends JpaRepository<LoanEntity,Integer> {
    List<LoanEntity> findAllById(Integer id);
}
