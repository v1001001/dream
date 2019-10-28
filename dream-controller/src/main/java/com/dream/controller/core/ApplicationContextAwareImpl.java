package com.dream.controller.core;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;


/**
 * @description: 实现ApplicationContextAware接口
 * @author lidongyang
 * @date 2019/10/24
 * @version 1.0
 */
public class ApplicationContextAwareImpl implements ApplicationContextAware {

    private ApplicationContext context;

    public Object getBean(String beanName) {
        return context.getBean(beanName);
    }

    public void setApplicationContext(ApplicationContext context) throws BeansException {
        this.context = context;

    }
}
