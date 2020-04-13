package com.lemeng.personal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 项目启动类
 *
 * @Author 张九星
 * @create 2020/4/7 10:54
 */
@SpringBootApplication
@EnableJpaAuditing
@EnableTransactionManagement
@ImportResource(locations = "classpath:config.xml")
public class ServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }
}
