package com.sensors.ocr_test.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sensors.ocr_test.entity.SensorType;
import com.sensors.ocr_test.repository.SensorTypeRepository;

@Service
public class SensorTypeService {
	
	@Autowired
	private SensorTypeRepository sensorTypeRepository;

	public SensorType getSensorType(int sensorTypeId) throws Exception{
		Optional<SensorType> sensor = sensorTypeRepository.findById(sensorTypeId);
		if(sensor.isPresent()){
			return sensor.get();
		}else{
			throw new Exception();
		}
	}
}
