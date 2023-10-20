package com.example.weathersensorrest.dto;

import com.example.weathersensorrest.entity.SensorEntity;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WeatherDTO {
    @NotNull
    @Min(-100)
    @Max(100)
    private int temperature;
    @NotNull
    private boolean rain;
    @NotNull
    private SensorEntity sensor;

    public WeatherDTO() {
    }

    public WeatherDTO(int temperature, boolean rain, SensorEntity sensor) {
        this.temperature = temperature;
        this.rain = rain;
        this.sensor = sensor;
    }
}
