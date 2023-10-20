package com.example.weathersensorrest.controller;

import com.example.weathersensorrest.dto.WeatherDTO;
import com.example.weathersensorrest.entity.WeatherEntity;
import com.example.weathersensorrest.exception.WeatherNotCreatedException;
import com.example.weathersensorrest.service.WeatherService;
import com.example.weathersensorrest.validation.WeatherValidation;
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

import java.time.LocalDateTime;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    private final WeatherService weatherService;
    private final WeatherValidation weatherValidation;
    private final ModelMapper modelMapper;

    @Autowired
    public WeatherController(WeatherService weatherService, WeatherValidation weatherValidation, ModelMapper modelMapper) {
        this.weatherService = weatherService;
        this.weatherValidation = weatherValidation;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/add")
    public ResponseEntity<HttpStatus> saveWeather(@RequestBody @Valid WeatherDTO weatherDTO, BindingResult bindingResult) {
        WeatherEntity weather = modelMapper.map(weatherDTO, WeatherEntity.class);
        weatherValidation.validate(weather, bindingResult);

        if (bindingResult.hasErrors()) {
            StringBuilder stringBuilder = new StringBuilder();
            bindingResult.getFieldErrors().forEach(fieldError -> stringBuilder
                    .append(fieldError.getField())
                    .append(": ")
                    .append(fieldError.getDefaultMessage()));
            throw new WeatherNotCreatedException(stringBuilder.toString());
        }

        weather.setTimestamp(LocalDateTime.now());
        weatherService.save(weather);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
