package com.sensors.ocr_test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sensors.ocr_test.entity.SensorType;

public interface SensorTypeRepository extends JpaRepository<SensorType, Integer>{
	
}
