package com.example.demo.controller;

import com.example.demo.util.JsonResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class LibraryControllerAdvice {

    @ExceptionHandler(value = RuntimeException.class)
    public JsonResponse exceptionHandler(RuntimeException e) {
        log.error("Controller catch exception: ", e);
        return JsonResponse.exception(e.getMessage());
    }
}
