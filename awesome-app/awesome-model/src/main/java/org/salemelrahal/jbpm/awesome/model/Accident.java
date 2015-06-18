package org.salemelrahal.jbpm.awesome.model;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Accident implements Serializable{
	private static final long serialVersionUID = 2032431217015565536L;
	private List<Car> cars;

	@XmlElement
	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}

	@Override
	public String toString() {
		String result = getClass().getSimpleName() + " ";
		if (cars != null)
			result += "cars: " + cars;
		return result;
	}

}
