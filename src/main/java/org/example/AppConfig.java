package org.example;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.SQLException;

@Configuration
public class AppConfig {

    @Bean
    public Connection databaseConnection() throws SQLException{
        return new DatabaseConnection().getConnection();

    }

    @Bean
    public StudentRepository repository() throws SQLException{
        return new StudentRepository(databaseConnection());
    }

    @Bean
    public StudentManager studentManager() throws SQLException{
        return new StudentManager(repository());
    }

}
