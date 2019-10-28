package com.dream.controller.core;

import org.springframework.context.support.ApplicationObjectSupport;

/**
 * @description: 继承ApplicationObjectSupport
 * @author lidongyang
 * @date 2019/10/24
 * @version 1.0
 */
public class ApplicationObjectSupportImpl extends ApplicationObjectSupport {

    /**
     * 提供一个接口,获取容器中的Bean实例,根据名称获取
     * @param beanName
     * @return
     */
    public Object getBean(String beanName)
    {
        return getApplicationContext().getBean(beanName);
    }

}
