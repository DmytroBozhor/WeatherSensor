package com.example.weathersensorrest.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "weather")
@Getter
@Setter
public class WeatherEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "temperature")
    @NotNull
    @Min(-100)
    @Max(100)
    private int temperature;
    @Column(name = "rain")
    @NotNull
    private boolean rain;
    @ManyToOne(targetEntity = SensorEntity.class)
    @JoinColumn(name = "sensor_fk", referencedColumnName = "name")
    @NotNull
    private SensorEntity sensor;
    @Column(name = "timestamp")
    private LocalDateTime timestamp;

    public WeatherEntity() {
    }

    public WeatherEntity(int temperature, boolean rain, SensorEntity sensor, LocalDateTime timestamp) {
        this.temperature = temperature;
        this.rain = rain;
        this.sensor = sensor;
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "WeatherEntity{" +
                "id=" + id +
                ", temperature=" + temperature +
                ", rain=" + rain +
                ", sensor=" + sensor +
                ", timestamp=" + timestamp +
                '}';
    }
}
