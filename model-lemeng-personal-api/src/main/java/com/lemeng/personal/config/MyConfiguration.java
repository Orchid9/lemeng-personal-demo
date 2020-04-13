package com.lemeng.personal.config;

import com.nhsoft.provider.data.annotation.config.DataModelScan;
import com.nhsoft.provider.data.annotation.config.EnableDataController;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @Author 张九星
 * @create 2020/4/13 14:41
 */
@Configuration
@EnableJpaRepositories("com.lemeng.personal")
@ComponentScan("com.lemeng.personal")
@DataModelScan("com.lemeng.personal.model")
public class MyConfiguration {
    @Configuration
    @EnableDataController(debugMode = true)
    @Profile("!production")
    public static class DebugConfiguration {

    }

    @Configuration
    @EnableDataController
    @Profile("production")
    public static class ProductionConfiguration {

    }

}
