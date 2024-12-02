package com.sensors.ocr_test.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.sensors.ocr_test.entity.Sensor;

public class RangeValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Sensor.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Sensor sensor = (Sensor) target;
		
		if(sensor.getRangeFrom() >= sensor.getRangeTo()){
			errors.rejectValue("rangeTo", "range.invalid", "Value in field 'from' must be lower than value in field 'to'");
		}
	}
	
}
