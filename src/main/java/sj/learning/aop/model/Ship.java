package sj.learning.aop.model;

public class Ship {

	private String name;
	
	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String setNameAndReturn(String name) {
		this.name = name;
		return this.name;
	}
}
