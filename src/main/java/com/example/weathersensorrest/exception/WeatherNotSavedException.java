package com.example.weathersensorrest.exception;

public class WeatherNotSavedException extends RuntimeException{
    public WeatherNotSavedException(String message) {
        super(message);
    }
}
