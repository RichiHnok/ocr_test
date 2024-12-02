package com.sensors.ocr_test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sensors.ocr_test.entity.Sensor;

public interface SensorRepository extends JpaRepository<Sensor, Integer>{
	public List<Sensor> findByNameContainingAndModelContaining(String name, String model);
}
