package com.pge.ei.sample.service;

import com.pge.ei.sample.model.Employee;

public class EmployeeAOP {

	private Employee employee;
	
	public Employee getEmployee(){
		return this.employee;
	}
	
	public void setEmployee(Employee e){
		this.employee=e;
	}
}