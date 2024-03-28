package com.springproject.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.datastax.oss.driver.api.core.CqlSession;

@Configuration
public class CassandraConfig {

	    @Bean
	    public CqlSession cqlSession() {
	        return CqlSession.builder()
	                .withKeyspace("your_keyspace_name") // Replace with your keyspace name
	                .build();
	    }
}
