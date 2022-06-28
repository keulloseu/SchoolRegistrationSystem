package com.java.schoolregistrationsystem.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PropertySourceResolver {

    @Value("${spring.datasource.url") private String datasourceUrl;
    @Value("${spring.datasource.username}") private String dataSourceUsername;
    @Value("${spring.datasource.password}") private String datasourcePassword;
    @Value("${spring.jpa.database-platform}") private String datasourceDialect;

    public String getDatasourceUrl() {
        return datasourceUrl;
    }

    public String getDataSourceUsername() {
        return dataSourceUsername;
    }

    public String getDatasourcePassword() {
        return datasourcePassword;
    }

    public String getDatasourceDialect() {
        return datasourceDialect;
    }
}
