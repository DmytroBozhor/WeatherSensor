package com.example.weathersensorrest.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class WeatherDTO {
    @Column(name = "temperature")
    @NotNull
    private int temperature;
    @Column(name = "rain")
    @NotNull
    private boolean rain;

    public WeatherDTO(int temperature, boolean rain) {
        this.temperature = temperature;
        this.rain = rain;
    }
}
