package com.pge.ei.sample.properties;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration
@PropertySource("classpath:ccbaccess2.properties")
public class ConfigPropertiesReader {
	
	@Autowired
	LSEMapping mapping;
	
	@Resource(name = "myProperties")
	private Map<String, String> myProperties;
	
	@Resource(name = "myProperties2")
	private Map<String, String> myProperties2;
	
	
	@Value("${mongodb.url}")
	private String mongodbUrl;

	
	@Value("${mongodb.db}")
	private String defaultDb;

	@Bean
	public String mongoTemplate() throws Exception {

		System.out.println("mondodburl :"+mongodbUrl);
		System.out.println("mongodb :"+defaultDb);
		
		System.out.println(myProperties.get("db.host"));
		
		System.out.println(myProperties2.get("mongodb.url"));
		
		System.out.println(mapping.getAdditionalHeaders().get("redelivery"));
		
		System.out.println(mapping.getAdditionalHeaders().get("secure"));
		return "mongosetupdone";

	}

}
