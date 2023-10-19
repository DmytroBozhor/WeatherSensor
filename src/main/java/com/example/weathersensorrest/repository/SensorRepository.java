package com.example.weathersensorrest.repository;

import com.example.weathersensorrest.entity.SensorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SensorRepository extends JpaRepository<SensorEntity, Integer> {
    Optional<SensorEntity> findByName(String name);
}
