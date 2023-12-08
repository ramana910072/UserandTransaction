package com.example.demo.controller;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
@Slf4j
public class EmployeeController {
    private final EmployeeService employeeService;


    @PostMapping("/post")
    public ResponseEntity<EmployeeDTO> post(@RequestBody EmployeeDTO employeeDTO){

        return new ResponseEntity<>(employeeService.post(employeeDTO), HttpStatus.OK);
    }
    @GetMapping("/all")
    public ResponseEntity<List<EmployeeDTO>> getAll(){
        return new ResponseEntity<>(employeeService.getAll(),HttpStatus.OK);
    }

    @PutMapping("/update/")
    public ResponseEntity<EmployeeDTO> update(@RequestBody EmployeeDTO employeeDTO){
        return new ResponseEntity<>(employeeService.update(employeeDTO),HttpStatus.OK);
    }
}
