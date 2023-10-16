package com.example.weathersensorrest.service;

import com.example.weathersensorrest.dto.WeatherDTO;
import com.example.weathersensorrest.entity.WeatherEntity;
import com.example.weathersensorrest.repository.WeatherRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class WeatherService {
    private final WeatherRepository weatherRepository;

    @Autowired
    public WeatherService(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }

    public void save(WeatherEntity weather) {
        weatherRepository.save(weather);
    }

    public void save(WeatherDTO weatherDTO) {
        weatherRepository.save(new ModelMapper().map(weatherDTO, WeatherEntity.class));
    }
}
