package com.huaxia.cai.common.logger.util;

import java.io.File;
import java.io.InputStream;
import java.util.Properties;

import ch.qos.logback.core.PropertyDefinerBase;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

/**
 * 获取属性值
 * @author leizhicheng
 *
 */
public class AppNamePropertyDefiner extends PropertyDefinerBase {
	
	private static final String APPID = "app.id";

	@Override
	public String getPropertyValue() {
		String appName =null;
		try {
			/**
			 * 获取apollo配置文件app.properties 中的app.id
			 */
			appName = getKeyByProperties(APPID);
			if(StringUtils.isNotBlank(appName)) {
				return appName;
			}

			String dir = System.getProperty("user.dir");
			if (dir != null) {
				appName = dir.substring(dir.lastIndexOf(File.separator) + 1)+"_";
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
