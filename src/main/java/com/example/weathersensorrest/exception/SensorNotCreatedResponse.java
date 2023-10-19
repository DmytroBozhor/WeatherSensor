package com.example.weathersensorrest.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SensorNotCreatedResponse {
    private String message;
    private long timestamp;

    public SensorNotCreatedResponse() {
    }

    public SensorNotCreatedResponse(String message, long timestamp) {
        this.message = message;
        this.timestamp = timestamp;
    }
}
