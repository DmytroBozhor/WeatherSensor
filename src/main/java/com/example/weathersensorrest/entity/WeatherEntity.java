package com.example.weathersensorrest.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "weather")
@Getter
@Setter
@NoArgsConstructor
public class WeatherEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "temperature")
    @Min(0)
    @Max(100)
    private int temperature;
    @Column(name = "rain")
    private boolean isRaining;

    public WeatherEntity(int temperature, boolean isRaining) {
        this.temperature = temperature;
        this.isRaining = isRaining;
    }
}
