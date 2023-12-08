package com.example.demo.service;
import com.example.demo.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
    EmployeeDTO post(EmployeeDTO employeeDTO);
    List<EmployeeDTO> getAll();

    EmployeeDTO update(EmployeeDTO employeeDTO);



}
