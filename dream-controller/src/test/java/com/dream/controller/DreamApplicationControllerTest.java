package com.dream.controller;


import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication(scanBasePackages = "com.dream.*")
@ImportResource({"classpath*:dubbo/spring-dubbo-*.xml"})
@MapperScan(basePackages = {"com.dream.dao.*"})
@EnableApolloConfig
public class DreamApplicationControllerTest {
    public static void main(String[] args) {
        SpringApplication.run(DreamApplicationControllerTest.class, args);
    }
}