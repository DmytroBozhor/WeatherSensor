package com.example.weathersensorrest.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SensorDTO {
    @NotNull
    @Size(min = 3, max = 30)
    @Column(name = "name")
    private String name;

    public SensorDTO() {
    }

    public SensorDTO(String name) {
        this.name = name;
    }
}
