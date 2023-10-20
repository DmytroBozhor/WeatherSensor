package com.example.weathersensorrest.validation;

import com.example.weathersensorrest.entity.SensorEntity;
import com.example.weathersensorrest.entity.WeatherEntity;
import com.example.weathersensorrest.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class WeatherValidation implements Validator {
    private final SensorService sensorService;

    @Autowired
    public WeatherValidation(SensorService sensorService) {
        this.sensorService = sensorService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(WeatherEntity.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        WeatherEntity weather = (WeatherEntity) target;
        Optional<SensorEntity> sensorEntityOptional = sensorService.findByName(weather.getSensor().getName());

        if (sensorEntityOptional.isEmpty()) {
            errors.rejectValue("sensor", "", "Sensor does not exist.");
        }
    }
}
