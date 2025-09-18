package com.souparnikar.gameclub.exceptions;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptions {
    
    @ExceptionHandler(IdNotPresentException.class)

    public String handleIdNotPresentException(IdNotPresentException ex){
        return ex.getMessage();
    }

    @ExceptionHandler(BusinessException.class)

    public String handleBusinessException(BusinessException ex){
        return ex.getMessage();
    }
}
