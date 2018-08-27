package com.huaxia.cai.common.logger.slf4j;

import ch.qos.logback.core.rolling.RollingFileAppender;

/**
 * custom appender 主要是為了解决appName属性问题
 * @author leizhicheng
 *
 * @param <E>
 */
public class HuaXiaRollingFileAppender<E> extends RollingFileAppender<E>{
	
	private String appName;
	
	
	public String getAppName() {
		return appName;
	}


	public void setAppName(String appName) {
		this.appName = appName;
	}

	
	public void start() {
		//设置属性
		System.setProperty("appName", appName);
		super.start();
	}

}
