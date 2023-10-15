package com.example.weathersensorrest.exception;

import lombok.Data;

@Data
public class WeatherNotCreatedResponse {
    private String message;
    private long timestamp;

    public WeatherNotCreatedResponse(String message, long timestamp) {
        this.message = message;
        this.timestamp = timestamp;
    }
}
