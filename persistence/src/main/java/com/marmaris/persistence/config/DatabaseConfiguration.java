package com.marmaris.persistence.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.flyway.FlywayDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.time.Clock;

@Configuration
@EnableJpaRepositories("com.marmaris.persistence")
@EntityScan("com.marmaris.persistence.dao")
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "database")
public class DatabaseConfiguration {

    private static Logger LOGGER = LoggerFactory.getLogger(DatabaseConfiguration.class);

    private String jdbcUrl;
    private String driverClassName;
    private String user;
    private String password;

    public void setJdbcUrl(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Bean
    public Clock getClock() {
        return Clock.systemUTC();
    }

    @Lazy
    @Bean
    @FlywayDataSource
    public HikariDataSource getHikariDataSource() {
        final HikariConfig config = getDatabaseConfiguration();
        return new HikariDataSource(config);
    }

    protected HikariConfig getDatabaseConfiguration() {
        final HikariConfig config = new HikariConfig();
        config.setDriverClassName(driverClassName);
        LOGGER.debug("DriverClassName {}", driverClassName);

        config.setJdbcUrl(jdbcUrl);
        LOGGER.debug("JdbcUrl {}", jdbcUrl);

        config.setUsername(user);
        config.setPassword(password);

        return config;
    }


}
