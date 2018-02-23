package com.pge.ei.sample.model;

import com.pge.ei.sample.aspect.Loggable;

import io.swagger.annotations.ApiModelProperty;

public class Employee {

	@ApiModelProperty(notes = "Name of the employee")
	private String name;
	
	public String getName() {
		return name;
	}

	@Loggable
	public void setName(String nm) {
		this.name=nm;
	}
	
	public void throwException(){
		throw new RuntimeException("Dummy Exception");
	}	
}