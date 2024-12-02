package com.sensors.ocr_test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sensors.ocr_test.entity.Sensor;
import com.sensors.ocr_test.enums.SensorTypeEnum;
import com.sensors.ocr_test.service.SensorService;
import com.sensors.ocr_test.service.SensorTypeService;
import com.sensors.ocr_test.validation.RangeValidator;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/admin")
public class SensorCrudController {

	@Autowired
	private SensorService sensorService;
	@Autowired
	private SensorTypeService sensorTypeService;
	
	@GetMapping("/")
	public String showAllSensors(Model model){
		List<Sensor> allSensors = sensorService.getAllSensors();
		model.addAttribute("allSensors", allSensors);
		return "sensor/sensors-editor";
	}

	@RequestMapping("/addSensor")
	public String addNewSensor(Model model){
		Sensor sensor = new Sensor();
		model.addAttribute("sensor", sensor);
		return "sensor/sensor-info";
	}

	@PostMapping(value = "/saveSensor")
	public String saveSensor(@Valid @ModelAttribute("sensor") Sensor sensor, BindingResult bindingResult) throws Exception{
		RangeValidator rangeValidator = new RangeValidator();
		rangeValidator.validate(sensor, bindingResult);
		
		if(bindingResult.hasErrors()){
			return "sensor/sensor-info";
		}else{
			switch (sensor.getSensorTypeEnum()) {
				case PRESSURE:
					sensor.setSensorType(sensorTypeService.getSensorType(1));
					break;
				case VOLTAGE:
					sensor.setSensorType(sensorTypeService.getSensorType(2));
					break;
				case TEMPERATURE:
					sensor.setSensorType(sensorTypeService.getSensorType(3));
					break;
				case HUMIDITY:
					sensor.setSensorType(sensorTypeService.getSensorType(4));
					break;
			}
			sensorService.saveSensor(sensor);
			return "redirect:/admin/";
		}
	}

	@RequestMapping("/updateInfo")
	public String updateSensor(@RequestParam("sensorId") int sensorId, Model model) throws Exception{
		Sensor sensor = sensorService.getSensor(sensorId);
		switch (sensor.getSensorType().getSensorTypeId()) {
			case 1:
				sensor.setSensorTypeEnum(SensorTypeEnum.PRESSURE);
				break;
			case 2:
				sensor.setSensorTypeEnum(SensorTypeEnum.VOLTAGE);
				break;
			case 3:
				sensor.setSensorTypeEnum(SensorTypeEnum.TEMPERATURE);
				break;
			case 4:
			sensor.setSensorTypeEnum(SensorTypeEnum.HUMIDITY);
				break;
		}
		model.addAttribute("sensor", sensor);
		return "sensor/sensor-info";
	}

	@RequestMapping("/deleteInfo")
	public String deleteSensor(@RequestParam("sensorId") int sensorId){
		sensorService.deleteSensor(sensorId);
		return "redirect:/admin/";
	}
}
