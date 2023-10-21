package com.example.weathersensorrest.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "sensor")
@Getter
@Setter
public class SensorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @NotNull
    @Size(min = 3, max = 30)
    @Column(name = "name")
    private String name;
    @JsonIgnore
    @OneToMany(targetEntity = WeatherEntity.class, mappedBy = "sensor")
    private List<WeatherEntity> weather;

    public SensorEntity() {
    }

    public SensorEntity(String name) {
        this.name = name;
    }
}
