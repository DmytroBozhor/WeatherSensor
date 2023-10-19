package com.example.weathersensorrest.service;

import com.example.weathersensorrest.dto.SensorDTO;
import com.example.weathersensorrest.entity.SensorEntity;
import com.example.weathersensorrest.repository.SensorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class SensorService {
    private final SensorRepository sensorRepository;

    @Autowired
    public SensorService(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }

    public void save(SensorEntity sensor) {
        sensorRepository.save(sensor);
    }

    public void save(SensorDTO sensorDTO) {
        sensorRepository.save(new ModelMapper().map(sensorDTO, SensorEntity.class));
    }

    public Optional<SensorEntity> findByName(String name){
        return sensorRepository.findByName(name);
    }
}
