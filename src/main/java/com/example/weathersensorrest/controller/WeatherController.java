package com.example.weathersensorrest.controller;

import com.example.weathersensorrest.dto.WeatherDTO;
import com.example.weathersensorrest.entity.WeatherEntity;
import com.example.weathersensorrest.exception.WeatherNotCreatedException;
import com.example.weathersensorrest.service.SensorService;
import com.example.weathersensorrest.service.WeatherService;
import com.example.weathersensorrest.validation.WeatherValidation;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    private final WeatherService weatherService;
    private final SensorService sensorService;
    private final WeatherValidation weatherValidation;
    private final ModelMapper modelMapper;

    @Autowired
    public WeatherController(WeatherService weatherService, SensorService sensorService, WeatherValidation weatherValidation, ModelMapper modelMapper) {
        this.weatherService = weatherService;
        this.sensorService = sensorService;
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
        weather.setSensor(sensorService.findByName(weather.getSensor().getName()).get());
        weatherService.save(weather);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<WeatherEntity>> getAllWeatherRecords(){
        return new ResponseEntity<>(weatherService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/all/rainy")
    public ResponseEntity<List<WeatherEntity>> getAllRainyRecords(){
        return new ResponseEntity<>(weatherService.findAllByRaining(true), HttpStatus.OK);
    }
}
