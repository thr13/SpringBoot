package com.boot.config;

import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.JdbcTransactionManager;
import org.springframework.transaction.TransactionManager;

import javax.sql.DataSource;

@Slf4j
@Configuration
public class DBConfig {

    /**
     * 트랜잭션 매니저에서 사용할 DataSource
     * @return DataSource
     */
    @Bean
    public DataSource dataSource() {
        log.info("dataSource 스프링 빈 등록");
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setJdbcUrl("jdbc:h2:mem:test");
        dataSource.setUsername("sa");
        dataSource.setPassword("");

        return dataSource;
    }

    /**
     * JdbcTemplate, DataSource 를 관리하는 스프링 트랜잭션 매니저
     * @return JdbcTransactionManager
     */
    @Bean
    public TransactionManager transactionManager() {
        log.info("transactionManager 스프링 빈 등록");
        return new JdbcTransactionManager(dataSource());
    }

    /**
     * 트랜잭션 매니저가 사용할 JdbcTemplate
     * @return JdbcTemplate
     */
    @Bean
    public JdbcTemplate jdbcTemplate() {
        log.info("jdbcTemplate 스프링 빈 등록");
        return new JdbcTemplate(dataSource());
    }
}
