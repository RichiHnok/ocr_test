package com.sensors.ocr_test.entity;

import com.sensors.ocr_test.enums.SensorTypeEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "sensor")
public class Sensor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sensor_id")
	private int sensorId;
	
	@Column(name = "name")
	@Size(min = 3, max = 30, message = "Name must contain from 3 to 30 characters")
	@NotBlank(message = "Model is required field")
	private String name;
	
	@Column(name = "model")
	@Size(max = 15, message = "Model must contain to 15 characters")
	@NotBlank(message = "Model is required field")
	private String model;
	
	@Column(name = "range_from")
	@Min(value = 0, message = "Value cannot be negative")
	@NotNull(message = "Range From is required field")
	private int rangeFrom;
	
	@Column(name = "range_to")
	@NotNull(message = "Range To is required field")
	private int rangeTo;
	
	@Transient
	private SensorTypeEnum sensorTypeEnum;

	@OneToOne
	@JoinColumn(name = "sensor_type_id")
	private SensorType sensorType;
	
	@Column(name = "location")
	@Size(max = 40, message = "Location must contain to 40 characters")
	private String location;
	
	@Column(name = "description")
	@Size(max = 200, message = "Description must contain to 15 characters")
	private String description;

	public Sensor() {
	}

	public Sensor(String name, String model, int rangeFrom, int rangeTo, SensorType sensorType, String location,
			String description) {
		this.name = name;
		this.model = model;
		this.rangeFrom = rangeFrom;
		this.rangeTo = rangeTo;
		this.sensorType = sensorType;
		this.location = location;
		this.description = description;
	}

	public int getSensorId() {
		return sensorId;
	}

	public void setSensorId(int sensorId) {
		this.sensorId = sensorId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getRangeFrom() {
		return rangeFrom;
	}

	public void setRangeFrom(int rangeFrom) {
		this.rangeFrom = rangeFrom;
	}

	public int getRangeTo() {
		return rangeTo;
	}

	public void setRangeTo(int rangeTo) {
		this.rangeTo = rangeTo;
	}

	public SensorType getSensorType() {
		return sensorType;
	}

	public void setSensorType(SensorType sensorType) {
		this.sensorType = sensorType;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Sensor [sensorId=" + sensorId + ", name=" + name + ", model=" + model + ", rangeFrom=" + rangeFrom
				+ ", rangeTo=" + rangeTo + ", sensorType=" + sensorType + ", location=" + location + ", description="
				+ description + "]";
	}

	public SensorTypeEnum getSensorTypeEnum() {
		return sensorTypeEnum;
	}

	public void setSensorTypeEnum(SensorTypeEnum sensorTypeEnum) {
		this.sensorTypeEnum = sensorTypeEnum;
	}
}
