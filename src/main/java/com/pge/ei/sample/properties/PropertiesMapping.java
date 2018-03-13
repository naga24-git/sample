package com.pge.ei.sample.properties;

import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
//@ConfigurationProperties(prefix = "custom")

public class PropertiesMapping {
	
	@Bean(name = "myProperties")
	public static PropertiesFactoryBean mapper() {
	    PropertiesFactoryBean bean = new PropertiesFactoryBean();
	    bean.setLocation(new ClassPathResource("ccbaccess.properties"));
	    return bean;
	}
	
	@Bean(name = "myProperties2")
	public static PropertiesFactoryBean mapper2() {
	    PropertiesFactoryBean bean = new PropertiesFactoryBean();
	    bean.setLocation(new ClassPathResource("ccbaccess2.properties"));
	    return bean;
	}

}
