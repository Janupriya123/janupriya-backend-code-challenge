package com.hexaware.cricteam.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PlayerNotFoundException.class)
    public String exceptionHandler(Exception ex)
    {
        return ex.getMessage();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handleValidationException(MethodArgumentNotValidException ex) {
        Map<String,String> map=new HashMap<>();
        ex.getBindingResult()
                .getFieldErrors()
                .forEach(error -> map.put(error.getField(), error.getDefaultMessage()));
        return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
    }

}
