package com.pge.ei.sample.service;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class SampleService {
	
	private static final Logger LOGGER = Logger.getLogger(SampleService.class);
	
	public void sampleMethod() {
		LOGGER.info("Entering Sample method..");	
	}

}
