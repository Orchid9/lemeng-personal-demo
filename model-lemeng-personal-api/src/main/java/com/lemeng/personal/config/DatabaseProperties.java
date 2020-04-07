package com.lemeng.personal.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

/**
 * 数据库配置属性
 *
 * @Author 张九星
 * @create 2020/4/7 14:28
 */
@Data
public class DatabaseProperties {
    @Value("${database.driverClassName}")
    private String dbDriverClassName;

    @Value("${database.username}")
    private String dbUserName;

    @Value("${database.password}")
    private String dbPassword;

    @Value("${database.url}")
    private String dbUrl;
}
