package com.example.userDeatils.dao;

import com.example.userDeatils.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<UserEntity,Integer> {
}
