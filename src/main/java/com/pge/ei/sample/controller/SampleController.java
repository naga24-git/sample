package com.pge.ei.sample.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pge.ei.sample.service.SampleService;

import io.swagger.annotations.ApiOperation;

@RestController
public class SampleController {
	
private static final Logger LOGGER = Logger.getLogger(SampleController.class);
	
	@Autowired
	private SampleService sampleService;
	
	@ApiOperation(value = "Sample Controller")
	@RequestMapping(method = RequestMethod.GET, value = "/sampleMethod")
	public void sampleMethod() {
		LOGGER.info("Calling sample service...");
		sampleService.sampleMethod();
	}
}
