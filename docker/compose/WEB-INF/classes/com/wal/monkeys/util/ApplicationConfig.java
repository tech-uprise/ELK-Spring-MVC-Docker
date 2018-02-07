package com.wal.monkeys.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:elk.properties")
public class ApplicationConfig {

	@Autowired
	Environment environment;

	@Bean
	ApplicationProperties appProperties() {
		ApplicationProperties bean = new ApplicationProperties();
		bean.setKafkaHost(environment.getProperty("kafka.host.url"));
		bean.setKafkaPort(environment.getProperty("kafka.host.port"));
		bean.setKafkaTpoic(environment.getProperty("kafka.topic.name"));
		return bean;
	}

}
