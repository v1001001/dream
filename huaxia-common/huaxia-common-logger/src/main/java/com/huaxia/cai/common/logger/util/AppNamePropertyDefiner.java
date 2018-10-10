package com.huaxia.cai.common.logger.util;

import java.io.File;
import java.io.InputStream;
import java.util.Properties;

import ch.qos.logback.core.PropertyDefinerBase;
import org.apache.commons.lang3.StringUtils;

/**
 * 获取属性值
 * @author leizhicheng
 *
 */
public class AppNamePropertyDefiner extends PropertyDefinerBase {
	
	private static final String APPID = "app.id";
	private static final String APPNAME = "app.name";

	@Override
	public String getPropertyValue() {
		String appName =null;
		try {
			/**
			 * 获取apollo配置文件app.properties 中的app.id
			 * 如果多个项目同时使用app.id，则多个项目日志名称会起冲突，
			 * 所以添加app.name参数区别不同的项目名称，优先取app.name，如果没有app.name，则获取app.id
			 */
			appName = getKeyByProperties(APPNAME);
			if(StringUtils.isNotBlank(appName)) {
				return appName;
			}

			appName = getKeyByProperties(APPID);
			if(StringUtils.isNotBlank(appName)) {
				return appName;
			}

			String dir = System.getProperty("user.dir");
			if (dir != null) {
				appName = dir.substring(dir.lastIndexOf(File.separator) + 1);
				System.setProperty("appName", appName);
			}
		} catch (Exception e) {
			appName="catalina";
			e.printStackTrace();
		}
		
		return appName;
	}

	public String getKeyByProperties(String key) {
		String value = "";
		InputStream input = null;
		try {
			// 获取classpath下的配置文件
			input = this.getClass().getClassLoader().getResourceAsStream("META-INF/app.properties") ;
			if(input != null) {
				Properties properties = new Properties();
				properties.load(input);
				value = properties.getProperty(key);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return value;

	}


}
