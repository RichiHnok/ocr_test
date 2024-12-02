package com.sensors.ocr_test.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sensors.ocr_test.entity.Sensor;
import com.sensors.ocr_test.repository.SensorRepository;

@Service
public class SensorService {
	
	@Autowired
	private SensorRepository sensorRepository;

	public List<Sensor> getAllSensors(){
		return sensorRepository.findAll();
	}

	public Sensor getSensor(int sensorId) throws Exception{
		Optional<Sensor> sensor = sensorRepository.findById(sensorId);
		if(sensor.isPresent()){
			return sensor.get();
		}else{
			throw new Exception();
		}
	}

	public void saveSensor(Sensor sensor){
		sensorRepository.save(sensor);
	}

	public void deleteSensor(int sensorId){
		sensorRepository.deleteById(sensorId);
	}

	public List<Sensor> findSensorsByNameAndModel(String nameFilter, String modelFilter){
		return sensorRepository.findByNameContainingAndModelContaining(nameFilter, modelFilter);
	}
}
