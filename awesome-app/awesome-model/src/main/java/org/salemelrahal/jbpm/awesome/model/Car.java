package org.salemelrahal.jbpm.awesome.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Car implements Serializable{
	private static final long serialVersionUID = -664135554504638L;
	private Person driver;
	private String make;
	private String model;
	private Integer year;

	@XmlElement
	public Person getDriver() {
		return driver;
	}

	public void setDriver(Person driver) {
		this.driver = driver;
	}

	@XmlElement
	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	@XmlElement
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@XmlElement
	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	@Override
	public String toString() {
		String result = getClass().getSimpleName() + " ";
		if (driver != null)
			result += "driver: " + driver;
		if (make != null && !make.trim().isEmpty())
			result += ", make: " + make;
		if (model != null && !model.trim().isEmpty())
			result += ", model: " + model;
		if (year != null)
			result += ", year: " + year;
		return result;
	}
}
