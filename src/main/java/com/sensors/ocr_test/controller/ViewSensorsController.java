package com.sensors.ocr_test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sensors.ocr_test.entity.Sensor;
import com.sensors.ocr_test.service.SensorService;

@Controller
@RequestMapping("/sensors")
public class ViewSensorsController {
	
	@Autowired
	private SensorService sensorService;

	@GetMapping("/")
	public String showSensors(Model model,
	@RequestParam(required=false) String filterByNameValue,
	@RequestParam(required=false) String filterByModelValue){
		List<Sensor> allSensors = sensorService.findSensorsByNameAndModel(filterByNameValue, filterByModelValue);
		model.addAttribute("filterByNameValue", filterByNameValue);
		model.addAttribute("filterByModelValue", filterByModelValue);
		model.addAttribute("allSensors", allSensors);
		return "sensor/view-sensors";
	}
}
