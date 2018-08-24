package com.huaxia.cai.common.logger;


import com.huaxia.cai.common.logger.util.NetUtils;

/**
 * 日志实现
 * 
 * @author leizhicheng
 *
 */
public class HuaxiaLogger implements Logger {

	private final String APP_NAME = "appName";

	private static String localIp = null;

	private Logger logger;

	public HuaxiaLogger(Logger logger) {
		this.logger = logger;
	}

	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	private String appendContextMessage(String msg) {
		String app = System.getProperty(APP_NAME);
		if (localIp == null || "".equals(localIp)) {
			synchronized (this) {
				localIp = NetUtils.getLocalIP();
			}
		}
		
		String log = msg + "[HXLog][HOST=" + localIp + "][APP=" + app + "]";

		return log;
	}

	public void trace(String msg, Throwable e) {
		try {
			logger.trace(appendContextMessage(msg), e);
		} catch (Throwable t) {
		}
	}

	public void trace(Throwable e) {
		try {
			logger.trace(e);
		} catch (Throwable t) {
		}
	}

	public void trace(String msg) {
		try {
			logger.trace(appendContextMessage(msg));
		} catch (Throwable t) {
		}
	}

	public void debug(String msg, Throwable e) {
		try {
			logger.debug(appendContextMessage(msg), e);
		} catch (Throwable t) {
		}
	}

	public void debug(Throwable e) {
		try {
			logger.debug(e);
		} catch (Throwable t) {
		}
	}

	public void debug(String msg) {
		try {
			logger.debug(appendContextMessage(msg));
		} catch (Throwable t) {
		}
	}

	public void info(String msg, Throwable e) {
		try {
			logger.info(appendContextMessage(msg), e);
		} catch (Throwable t) {
		}
	}

	public void info(String msg) {
		try {
			logger.info(appendContextMessage(msg));
		} catch (Throwable t) {
		}
	}

	public void warn(String msg, Throwable e) {
		try {
			logger.warn(appendContextMessage(msg), e);
		} catch (Throwable t) {
		}
	}

	public void warn(String msg) {
		try {
			logger.warn(appendContextMessage(msg));
		} catch (Throwable t) {
		}
	}

	public void error(String msg, Throwable e) {
		try {
			logger.error(appendContextMessage(msg), e);
		} catch (Throwable t) {
		}
	}

	public void error(String msg) {
		try {
			logger.error(appendContextMessage(msg));
		} catch (Throwable t) {
		}
	}

	public void error(Throwable e) {
		try {
			logger.error(e);
		} catch (Throwable t) {
		}
	}

	public void info(Throwable e) {
		try {
			logger.info(e);
		} catch (Throwable t) {
		}
	}

	public void warn(Throwable e) {
		try {
			logger.warn(e);
		} catch (Throwable t) {
		}
	}

	public boolean isTraceEnabled() {
		try {
			return logger.isTraceEnabled();
		} catch (Throwable t) {
			return false;
		}
	}

	public boolean isDebugEnabled() {
		try {
			return logger.isDebugEnabled();
		} catch (Throwable t) {
			return false;
		}
	}

	public boolean isInfoEnabled() {
		try {
			return logger.isInfoEnabled();
		} catch (Throwable t) {
			return false;
		}
	}

	public boolean isWarnEnabled() {
		try {
			return logger.isWarnEnabled();
		} catch (Throwable t) {
			return false;
		}
	}

	public boolean isErrorEnabled() {
		try {
			return logger.isErrorEnabled();
		} catch (Throwable t) {
			return false;
		}
	}
}
