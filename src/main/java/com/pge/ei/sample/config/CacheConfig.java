package com.pge.ei.sample.config;

import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
public class CacheConfig {
	 @Bean
	    public EhCacheCacheManager ehCacheCacheManager() {
		 
		 	EhCacheManagerFactoryBean cacheManagerFactoryBean = new EhCacheManagerFactoryBean();
	        cacheManagerFactoryBean.setConfigLocation(new ClassPathResource("ehcache.xml"));
	        cacheManagerFactoryBean.setShared(true);

	        return new EhCacheCacheManager(cacheManagerFactoryBean.getObject());
	    }
}
