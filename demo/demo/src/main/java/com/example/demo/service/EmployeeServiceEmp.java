package com.example.demo.service;

import com.example.demo.dao.EmployeeDAO;
import com.example.demo.dto.EmployeeDTO;
import com.example.demo.entity.EmployeeEntity;
import com.example.demo.exception.EmployeeException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class EmployeeServiceEmp implements EmployeeService {

    private final EmployeeDAO employeeDAO;
    private final static Logger log = LoggerFactory.getLogger(EmployeeServiceEmp.class);

    @Override
    public EmployeeDTO post(EmployeeDTO employeeDTO) {
        log.debug("EmployeeServiceEmp ::post()  Call Started");
        try {
            EmployeeEntity employeeEntity = new EmployeeEntity();
            employeeEntity.setId(employeeDTO.getId());
            if (employeeDAO.existsById(employeeDTO.getId())) {
                throw new EmployeeException("This Id already Exists");
            }
            employeeEntity.setName(employeeDTO.getName());
            employeeEntity.setJoiningDate(employeeDTO.getJoiningDate());
            employeeDAO.save(employeeEntity);
            log.debug("Data stored in DB {}", employeeEntity);
        }
        catch (EmployeeException e)
        {
            throw new RuntimeException(e);
        }
        return employeeDTO;
    }
    @Override
    public List<EmployeeDTO> getAll(){
        log.debug("EmployeeServiceEmp::getAll()  Call started");
        List<EmployeeEntity> employeeEntities = employeeDAO.findAll();
        List<EmployeeDTO> employeeDTOS = new ArrayList<>();
        for(EmployeeEntity employeeEntity :employeeEntities){

            EmployeeDTO employeeDTO = new EmployeeDTO();
            employeeDTO.setId(employeeEntity.getId());
            employeeDTO.setName(employeeEntity.getName());
            employeeDTO.setJoiningDate(employeeEntity.getJoiningDate());
            employeeDTOS.add(employeeDTO);
            log.debug("All data Displayed {}",employeeDTO);
        }
        return employeeDTOS;
    }
    public EmployeeDTO update(EmployeeDTO employeeDTO){
        log.debug("EmployeeServiceEmp::update() Call started");
        Optional<EmployeeEntity>optional = employeeDAO.findById(employeeDTO.getId());

        EmployeeEntity employeeEntity = optional.get();
        employeeEntity.setName(employeeDTO.getName());
        employeeEntity.setJoiningDate((employeeDTO.getJoiningDate()));
        employeeEntity = employeeDAO.saveAndFlush(employeeEntity);

        log.debug("Data stored in DB {}",employeeEntity);
        return employeeDTO;
    }
}
