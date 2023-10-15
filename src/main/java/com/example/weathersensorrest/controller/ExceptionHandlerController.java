package com.example.weathersensorrest.controller;

import com.example.weathersensorrest.exception.WeatherNotCreatedResponse;
import com.example.weathersensorrest.exception.WeatherNotSavedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(WeatherNotSavedException.class)
    public ResponseEntity<WeatherNotCreatedResponse> handleException(WeatherNotSavedException e) {
        WeatherNotCreatedResponse weatherNotCreatedResponse = new WeatherNotCreatedResponse(
                e.getMessage(), System.currentTimeMillis());
        return new ResponseEntity<>(weatherNotCreatedResponse, HttpStatus.BAD_REQUEST);
    }
}
