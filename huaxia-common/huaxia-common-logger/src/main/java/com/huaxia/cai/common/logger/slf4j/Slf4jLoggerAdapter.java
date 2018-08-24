package com.huaxia.cai.common.logger.slf4j;

import java.io.File;

import com.huaxia.cai.common.logger.Level;
import com.huaxia.cai.common.logger.Logger;
import com.huaxia.cai.common.logger.LoggerAdapter;

/**
 * sl4j日志适配
 * 
 * @author leizhicheng
 *
 */
public class Slf4jLoggerAdapter implements LoggerAdapter {

	private File file;
	private Level level;

	public Logger getLogger(String key) {
		return new Slf4jLogger(org.slf4j.LoggerFactory.getLogger(key));
	}

	public Logger getLogger(Class<?> key) {
		return new Slf4jLogger(org.slf4j.LoggerFactory.getLogger(key));
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}
	
	

}
