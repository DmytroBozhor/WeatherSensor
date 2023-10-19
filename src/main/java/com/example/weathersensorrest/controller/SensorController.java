package com.example.weathersensorrest.controller;

import com.example.weathersensorrest.dto.SensorDTO;
import com.example.weathersensorrest.entity.SensorEntity;
import com.example.weathersensorrest.exception.SensorNotCreatedException;
import com.example.weathersensorrest.service.SensorService;
import com.example.weathersensorrest.validation.SensorUniqueNameValidation;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sensors")
public class SensorController {

    private final SensorService sensorService;
    private final SensorUniqueNameValidation validation;

    @Autowired
    public SensorController(SensorService sensorService, SensorUniqueNameValidation validation) {
        this.sensorService = sensorService;
        this.validation = validation;
    }

    @PostMapping("/registration")
    public ResponseEntity<HttpStatus> register(@RequestBody @Valid SensorDTO sensorDTO, BindingResult bindingResult) {

        validation.validate(new ModelMapper().map(sensorDTO, SensorEntity.class), bindingResult);

        if (bindingResult.hasErrors()) {
            StringBuilder stringBuilder = new StringBuilder();
            bindingResult.getFieldErrors().forEach(fieldError -> stringBuilder
                    .append(fieldError.getField())
                    .append(": ")
                    .append(fieldError.getDefaultMessage()));
            throw new SensorNotCreatedException(stringBuilder.toString());
        }

        sensorService.save(sensorDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
