package com.pge.ei.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pge.ei.sample.service.EmployeeAOP;

@SpringBootApplication
public class SampleApplication {

	public static void main(String[] args) {
		//SpringApplication.run(SampleApplication.class, args);
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		EmployeeAOP employeeService = ctx.getBean("employeeService", EmployeeAOP.class);
		
		System.out.println(employeeService.getEmployee().getName());
		
		employeeService.getEmployee().setName("Chitti");
		
		employeeService.getEmployee().throwException();
		
		ctx.close();
	}
}
