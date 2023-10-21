package com.example.weathersensorrest.repository;

import com.example.weathersensorrest.entity.WeatherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WeatherRepository extends JpaRepository<WeatherEntity, Integer> {
    List<WeatherEntity> findAllByRain(Boolean raining);
}
