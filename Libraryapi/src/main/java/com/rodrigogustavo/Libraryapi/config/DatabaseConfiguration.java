package com.rodrigogustavo.Libraryapi.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfiguration {

    @Value("${spring.datasource.url}")
    String url;
    @Value("${spring.datasource.username}")
    String user;
    @Value("${spring.datasource.password}")
    String passwd;
    @Value("${spring.datasource.driver-class-name}")
    String driver;

    @Bean
    public DataSource hikariDataSource(){
        HikariConfig config = new HikariConfig();

        config.setJdbcUrl(url);
        config.setUsername(user);
        config.setPassword(passwd);
        config.setDriverClassName(driver);

        config.setMaximumPoolSize(10);//o tamanho maximo do pool de conexoes
        config.setMinimumIdle(1);//o tamanho minimo do pool
        config.setPoolName("library-db-pool");//o nome do pool
        config.setMaxLifetime(600000);//o tempo de duração do pool
        config.setConnectionTimeout(50000);//timeout do pool
        config.setConnectionTestQuery("select 1");//query de teste

        return new HikariDataSource(config);
    }
}
