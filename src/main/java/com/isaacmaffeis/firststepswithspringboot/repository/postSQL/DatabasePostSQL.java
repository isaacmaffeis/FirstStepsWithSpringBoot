package com.isaacmaffeis.firststepswithspringboot.repository.postSQL;

import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
@Log
public class DatabasePostSQL implements CommandLineRunner {

    DataSource dataSource;

    public DatabasePostSQL(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /*
        spring.datasource.url=jdbc:postgresql://localhost:5432/postgres
        spring.datasource.username=postgres
        spring.datasource.password=changemeinprod!
        spring.datasource.driver-class-name=org.postgresql.Driver
     */

    @Override
    public void run(String... args) throws Exception {
        log.info("Datasource: " + dataSource.toString());
        final JdbcTemplate restTemplate = new JdbcTemplate(dataSource);
        restTemplate.execute("select 1");
    }
}
