package com.example.weathersensorrest.controller;

import com.example.weathersensorrest.dto.WeatherDTO;
import com.example.weathersensorrest.entity.WeatherEntity;
import com.example.weathersensorrest.exception.WeatherNotCreatedException;
import com.example.weathersensorrest.service.WeatherService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    private final WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @PostMapping("/new")
    public ResponseEntity<HttpStatus> saveWeather(@RequestBody @Valid WeatherDTO weatherDTO, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            StringBuilder stringBuilder = new StringBuilder();
            bindingResult.getFieldErrors().forEach(fieldError -> stringBuilder
                    .append(fieldError.getField())
                    .append(": ")
                    .append(fieldError.getDefaultMessage()));
            throw new WeatherNotCreatedException(stringBuilder.toString());
        }
        weatherService.save(weatherDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
