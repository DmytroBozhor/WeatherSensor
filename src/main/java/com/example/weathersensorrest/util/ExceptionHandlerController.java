package com.example.weathersensorrest.util;

import com.example.weathersensorrest.exception.SensorNotCreatedException;
import com.example.weathersensorrest.exception.SensorNotCreatedResponse;
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

    @ExceptionHandler(SensorNotCreatedException.class)
    public ResponseEntity<SensorNotCreatedResponse> handleException(SensorNotCreatedException e) {
        SensorNotCreatedResponse sensorNotCreatedResponse = new SensorNotCreatedResponse(
                e.getMessage(), System.currentTimeMillis());
        return new ResponseEntity<>(sensorNotCreatedResponse, HttpStatus.BAD_REQUEST);
    }
}
