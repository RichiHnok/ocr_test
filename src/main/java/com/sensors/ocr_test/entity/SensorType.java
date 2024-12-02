package com.sensors.ocr_test.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "sensor_type")
public class SensorType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sensor_type_id")
	private int sensorTypeId;
	
	@Column(name = "type")
	private String type;

	@Column(name = "unit")
	private String unit;

	public SensorType() {
	}

	public SensorType(String type, String unit) {
		this.type = type;
		this.unit = unit;
	}

	public int getSensorTypeId() {
		return sensorTypeId;
	}

	public void setSensorTypeId(int sensorTypeId) {
		this.sensorTypeId = sensorTypeId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	@Override
	public String toString() {
		return "SensorType [sensorTypeId=" + sensorTypeId + ", type=" + type + ", unit=" + unit + "]";
	}
	
}
