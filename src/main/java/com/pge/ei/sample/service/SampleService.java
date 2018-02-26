package com.pge.ei.sample.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;


@Service
@Configuration
@EnableCaching
public class SampleService {
	
	@Autowired
    private CacheManager ehCacheCacheManager;
	 
	private static final Logger LOGGER = Logger.getLogger(SampleService.class);
	
	public void sampleMethod() {
		LOGGER.info("Entering Sample method..");	
		Cache cache = ehCacheCacheManager.getCache("cache1");	
		cache.put("1","Jan");
		cache.put("2","Feb");
		cache.put("3","Mar");
		String ele = (String) cache.get("1").get();
		System.out.println(ele);
		LOGGER.info("Entering Sample method..");
	}
	
	public void sampleException(String name) {
		LOGGER.info("Entering Sample exception..");
		if("exc".equals(name)) {
			LOGGER.info("Throwing Exception");
			throw new NullPointerException();
		}
	}

}
