package com.example.transaction.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponce {

    private String message;
    private String pathURI;
    private LocalDate date;
}
