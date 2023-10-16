package com.example.weathersensorrest.controller;

import com.example.weathersensorrest.exception.WeatherNotCreatedResponse;
import com.example.weathersensorrest.exception.WeatherNotCreatedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(WeatherNotCreatedException.class)
    public ResponseEntity<WeatherNotCreatedResponse> handleException(WeatherNotCreatedException e) {
        WeatherNotCreatedResponse weatherNotCreatedResponse = new WeatherNotCreatedResponse(
                e.getMessage(), System.currentTimeMillis());
        return new ResponseEntity<>(weatherNotCreatedResponse, HttpStatus.BAD_REQUEST);
    }
}
