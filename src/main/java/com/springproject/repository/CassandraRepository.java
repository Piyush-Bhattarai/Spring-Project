package com.springproject.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.datastax.oss.driver.api.core.CqlSession;

@Repository
public class CassandraRepository {
	
	
	private final CqlSession cqlSession;

	@Autowired
    public CassandraRepository(CqlSession cqlSession) {
        this.cqlSession = cqlSession;
    }

}
