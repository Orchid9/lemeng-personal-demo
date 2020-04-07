package com.lemeng.personal.config;

import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.filter.logging.Slf4jLogFilter;
import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.pool.DruidDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author 张九星
 * @create 2020/4/7 18:04
 */
@Configuration
@Slf4j
public class Config {
    @Bean
    public DataSource dataSource(DatabaseProperties databaseProperties) {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(databaseProperties.getDbDriverClassName());
        dataSource.setUrl(databaseProperties.getDbUrl());
        dataSource.setUsername(databaseProperties.getDbUserName());
        dataSource.setPassword(databaseProperties.getDbPassword());
        dataSource.setMaxWait(1000);
        dataSource.setTestWhileIdle(false);

        try {
            dataSource.getConnection();
        } catch (SQLException e) {
            log.error("Datasource get connection failed", e);
            System.exit(1);
        }
        List<Filter> filters = new ArrayList<>();
        Slf4jLogFilter slf4jLogFilter = new Slf4jLogFilter();
        slf4jLogFilter.setStatementExecutableSqlLogEnable(true);
        filters.add(slf4jLogFilter);
        StatFilter statfilter = new StatFilter();
        statfilter.setMergeSql(true);
        statfilter.setLogSlowSql(true);
        statfilter.setSlowSqlMillis(1000);
        filters.add(statfilter);
        dataSource.setProxyFilters(filters);
        return dataSource;
    }
}
