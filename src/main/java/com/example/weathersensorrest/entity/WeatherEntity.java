package com.example.weathersensorrest.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
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
    @NotNull
    private int temperature;
    @Column(name = "rain")
    @NotNull
    private boolean rain;

    public WeatherEntity(int temperature, boolean rain) {
        this.temperature = temperature;
        this.rain = rain;
    }
}
