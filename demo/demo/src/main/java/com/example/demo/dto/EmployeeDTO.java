package com.example.demo.dto;

import com.example.demo.entity.EmployeeEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {

    private Integer id;
    private String name;
    private Date joiningDate;

    public EmployeeDTO(EmployeeEntity employeeEntity) {
    }

    public EmployeeDTO(String name) {
    }
}
