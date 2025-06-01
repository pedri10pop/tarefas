package com.pedro.tarefas.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.pedro.tarefas.exception.RecordNotFoundException;

@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler(RecordNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public String handleNotFoundException(RecordNotFoundException e) {
        return e.getMessage();
    }

}