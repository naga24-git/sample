package com.pge.ei.sample.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pge.ei.sample.kafka.KafkaProducer;
import com.pge.ei.sample.service.SampleService;

import io.swagger.annotations.ApiOperation;

@RestController
public class SampleController {

	private static final Logger LOGGER = Logger.getLogger(SampleController.class);

	@Autowired
	private SampleService sampleService;

	@Autowired
	private KafkaProducer kafkaProducer;

	@ApiOperation(value = "Sample Controller")
	@RequestMapping(method = RequestMethod.GET, value = "/sampleMethod")
	public void sampleMethod() {
		LOGGER.info("Calling sample service...");
		sampleService.sampleMethod();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/sendMessage")
	public void sendMessage() {
		LOGGER.info("Calling sendMessage...");
		kafkaProducer.send("Hello World KAFKA");
		LOGGER.info("After Calling sendMessage...");
	}

}
