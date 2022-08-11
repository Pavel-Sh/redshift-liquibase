package com.example.redshift.configuration;

import liquibase.integration.spring.SpringLiquibase;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class RedshiftConfiguration {

    @Bean(name = "redshiftDataSource")
    @ConfigurationProperties(prefix = "spring.redshift")
    public DataSource redshiftDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public JdbcTemplate localJdbcTemplate(@Qualifier("redshiftDataSource")DataSource dataSource) {
        JdbcTemplate template = new JdbcTemplate();
        template.setDataSource(dataSource);
        return new JdbcTemplate(dataSource);
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.redshift.liquibase")
    public LiquibaseProperties redshiftLiquibaseProperties() {
        return new LiquibaseProperties();
    }

    @Bean
    public SpringLiquibase secondaryLiquibase() {
        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setDataSource(redshiftDataSource());
        liquibase.setChangeLog(redshiftLiquibaseProperties().getChangeLog());
        liquibase.setContexts(redshiftLiquibaseProperties().getContexts());
        liquibase.setDefaultSchema(redshiftLiquibaseProperties().getDefaultSchema());
        liquibase.setDropFirst(redshiftLiquibaseProperties().isDropFirst());
        liquibase.setShouldRun(redshiftLiquibaseProperties().isEnabled());
        liquibase.setLabels(redshiftLiquibaseProperties().getLabels());
        liquibase.setChangeLogParameters(redshiftLiquibaseProperties().getParameters());
        liquibase.setRollbackFile(redshiftLiquibaseProperties().getRollbackFile());
        return liquibase;
    }
}
