package sj.learning.aop.model;

import sj.learning.aop.Loggable;

public class Car {

	private String name;
	
	private String model;

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getName() {
		return name;
	}

	@Loggable
	public String setName(String name) {
		this.name = name;
		return name;
	}
	
}
