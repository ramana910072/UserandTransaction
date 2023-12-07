package com.example.userDeatils.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "userDetails")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

    @Id
    private Integer id;
    private String name;

}
