package sj.learning.aop;

import sj.learning.aop.model.Car;
import sj.learning.aop.model.Ship;

public class VehicleService {
	
	private Car car;
	private Ship ship;

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public Ship getShip() {
		return ship;
	}

	public void setShip(Ship ship) {
		this.ship = ship;
	}

}
