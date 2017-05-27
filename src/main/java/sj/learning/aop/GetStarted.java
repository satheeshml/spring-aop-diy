package sj.learning.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GetStarted {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("aop-context.xml");
		VehicleService service = ctx.getBean("vehicleService", VehicleService.class);
		service.getCar().setName("Hundai");
		service.getCar().setModel("i10");
		service.getShip().setNameAndReturn("Royal Caribbean");
		service.getShip().setType("Passanger");
		
	}
}
