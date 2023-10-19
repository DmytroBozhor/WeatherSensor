package com.example.weathersensorrest.validation;

import com.example.weathersensorrest.entity.SensorEntity;
import com.example.weathersensorrest.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class SensorUniqueNameValidation implements Validator {
    private final SensorService sensorService;

    @Autowired
    public SensorUniqueNameValidation(SensorService sensorService) {
        this.sensorService = sensorService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(SensorEntity.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        SensorEntity sensor = (SensorEntity) target;
        Optional<SensorEntity> sensorEntityOptional = sensorService.findByName(sensor.getName());

        if (sensorEntityOptional.isPresent()) {
            errors.rejectValue("name", "", "This sensor already exists.");
        }
    }
}
