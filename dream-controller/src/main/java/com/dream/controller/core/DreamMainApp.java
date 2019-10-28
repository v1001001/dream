package com.dream.controller.core;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 * 说明: TODO
 * @author
 */
@SpringBootApplication
@EnableTransactionManagement
@EnableCaching
@MapperScan(basePackages = "com.dream.dao.*")
@ImportResource({"classpath*:dubbo/spring-dubbo-*.xml"})
@EnableApolloConfig({"dream"})
public class DreamMainApp {
    @Bean
    @ConditionalOnMissingBean
    public ApplicationObjectSupportImpl setSpringBeanUtils(ApplicationContext context){
        ApplicationObjectSupportImpl beanUtils = new ApplicationObjectSupportImpl();
        beanUtils.setApplicationContext(context);
        return beanUtils;
    }

    public static void main(String[] args) {

        new SpringApplicationBuilder(DreamMainApp.class).web(true).run(args);
    }
}
