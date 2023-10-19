package com.example.weathersensorrest.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

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

    public SensorEntity() {
    }

    public SensorEntity(String name) {
        this.name = name;
    }
}
