package com.isaacmaffeis.firststepswithspringboot.repository.h2;

import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
@Log
public class DatabaseH2 implements CommandLineRunner {

    private final DataSource dataSource;

    public DatabaseH2(final DataSource dataSource) {
        this.dataSource = dataSource;
    }

    // default automatically create a bean to connect (example) url=jdbc:h2:mem:d949336c-81dc-484b-9d1b-5466b41f9a05 user=SA
    // or specify one explicitly in application.propetries (name,where,user,password)
    /*
    spring.datasource.url=jdbc:h2:mem:testdb
    spring.datasource.driverClassName=org.h2.Driver
    spring.datasource.username=sa
    spring.datasource.password=password
     */

    @Override
    public void run(String... args) throws Exception {
        log.info("Datasource: " + dataSource.toString());
        final JdbcTemplate restTemplate = new JdbcTemplate(dataSource);
        restTemplate.execute("select 1"); // query
    }
}
