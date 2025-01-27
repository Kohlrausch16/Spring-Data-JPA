package com.springProjetc.springJPA.configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DataBasePollConfiguration {

    @Value("${spring.datasource.url}")              // estancia os parâmetros de conexão da aplicação
    String url;
    @Value("${spring.datasource.username}")
    String username;
    @Value("${spring.datasource.password}")
    String password;
    @Value("${spring.datasource.driver}")
    String driver;

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setUrl(url);
        ds.setUsername(username);
        ds.setPassword(password);
        ds.setDriverClassName(driver);
        return ds;
    }

    @Bean
    public DataSource hikariDataSource(){

        HikariConfig config = new HikariConfig();

        config.setUsername(username);
        config.setPassword(password);
        config.setDriverClassName(driver);
        config.setJdbcUrl(url);

        config.setMaximumPoolSize(10);   // define o tamanho máximo do pool;
        config.setMinimumIdle(1);       // define o tamanho mínimo/inicial do pool;
        config.setPoolName("jpa-db-pool"); // define o nome do pool;
        config.setMaxLifetime(600000); // define o numero máximo de conexões do pool;
        config.setConnectionTimeout(100000);  //define o tempo máximo de tentativa de conxão. Ao espirar, o Hikari tenta a conexõ com outro pool;
        config.setConnectionTestQuery("Select 1");  // teste de conexão com o banco(operação realizada para testar o reotnro do banco)

        return new HikariDataSource(config);
    }

}
