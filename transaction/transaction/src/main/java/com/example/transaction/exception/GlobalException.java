package com.example.transaction.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.util.ServletRequestPathUtils;

import java.time.LocalDate;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponce>responceResponseEntity(ResourceNotFoundException exception, HttpServletRequest request){
        ErrorResponce errorResponce = new ErrorResponce();
        errorResponce.setMessage(exception.getMessage());
        errorResponce.setPathURI(request.getRequestURI());
        errorResponce.setDate(LocalDate.now());
        return new ResponseEntity<>(errorResponce, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
