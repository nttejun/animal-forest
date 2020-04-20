package com.wonjun.animalforest.animalforest.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
//@SpringBootTest(properties = "spring.datasource.url=''")
public class WikiRepositoryTest {

  @Autowired
  DataSource dataSource;

  @Autowired
  JdbcTemplate jdbcTemplate;

  @Autowired
  WikiRepository wikiRepository;

  @Test
  public void di()throws SQLException {
    try(Connection connection = dataSource.getConnection()) {
      DatabaseMetaData metaData = connection.getMetaData();
      System.out.println(metaData.getURL());
      System.out.println(metaData.getDriverName());
      System.out.println(metaData.getUserName());
    }

  }
}