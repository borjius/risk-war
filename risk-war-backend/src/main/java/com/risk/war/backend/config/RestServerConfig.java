package com.risk.war.backend.config;

import java.util.Map;

import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.google.common.collect.ImmutableList;

@Configuration
public class RestServerConfig {
	
	private final static Logger log = LoggerFactory.getLogger(RestServerConfig.class);
	
	@Value("${rest.host}")
	String host;
	
	@Value("${rest.port}")
	String port;
	
	@Bean
	public Server jaxRsServer(ApplicationContext appContext) {
		log.info("Creating jaxrs server...");
		JAXRSServerFactoryBean sf = new JAXRSServerFactoryBean();
		
		Map<String, Object> services = appContext.getBeansWithAnnotation(Service.class);
		sf.setServiceBeans(ImmutableList.of(services.values()));
		JacksonJsonProvider jsonProvider = new JacksonJsonProvider();
		sf.setProviders(ImmutableList.of(jsonProvider));
		sf.setAddress("http://" + host + ":" + port + "/");

		return sf.create();
	}


}
