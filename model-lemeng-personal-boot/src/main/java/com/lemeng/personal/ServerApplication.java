package com.lemeng.personal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * 项目启动类
 *
 * @Author 张九星
 * @create 2020/4/7 10:54
 */
@SpringBootApplication
@EnableJpaAuditing
public class ServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }
}
