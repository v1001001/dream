package com.huaxia.cai.common.logger.slf4j;

import java.io.Serializable;

import org.slf4j.spi.LocationAwareLogger;

import com.huaxia.cai.common.logger.HuaxiaLogger;
import com.huaxia.cai.common.logger.Logger;


public class Slf4jLogger implements Logger, Serializable {

    private static final long serialVersionUID = 1L;

    private static final String FQCN = HuaxiaLogger.class.getName();

    private final org.slf4j.Logger logger;

    private final LocationAwareLogger locationAwareLogger;

    public Slf4jLogger(org.slf4j.Logger logger) {
        if (logger instanceof LocationAwareLogger) {
            locationAwareLogger = (LocationAwareLogger) logger;
        } else {
            locationAwareLogger = null;
        }
        this.logger = logger;
    }

    public void trace(String msg) {
        if (locationAwareLogger != null) {
            locationAwareLogger.log(null, FQCN, LocationAwareLogger.TRACE_INT, msg, null, null);
            return;
        }
        logger.trace(msg);
    }

    public void trace(Throwable e) {
        if (locationAwareLogger != null) {
            locationAwareLogger.log(null, FQCN, LocationAwareLogger.TRACE_INT, e.getMessage(), null, e);
            return;
        }
        logger.trace(e.getMessage(), e);
    }

    public void trace(String msg, Throwable e) {
        if (locationAwareLogger != null) {
            locationAwareLogger.log(null, FQCN, LocationAwareLogger.TRACE_INT, msg, null, e);
            return;
        }
        logger.trace(msg, e);
    }

    public void debug(String msg) {
        if (locationAwareLogger != null) {
            locationAwareLogger.log(null, FQCN, LocationAwareLogger.DEBUG_INT, msg, null, null);
            return;
        }
        logger.debug(msg);
    }

    public void debug(Throwable e) {
        if (locationAwareLogger != null) {
            locationAwareLogger.log(null, FQCN, LocationAwareLogger.DEBUG_INT, e.getMessage(), null, e);
            return;
        }
        logger.debug(e.getMessage(), e);
    }

    public void debug(String msg, Throwable e) {
        if (locationAwareLogger != null) {
            locationAwareLogger.log(null, FQCN, LocationAwareLogger.DEBUG_INT, msg, null, e);
            return;
        }
        logger.debug(msg, e);
    }
    
    @Override
	public void debug(String format, Object... argArray) {
    	if (locationAwareLogger != null) {
            locationAwareLogger.log(null, FQCN, LocationAwareLogger.DEBUG_INT, format, argArray, null);
            return;
        }
        logger.debug(format,argArray);
		
	}

    public void info(String msg) {
        if (locationAwareLogger != null) {
            locationAwareLogger.log(null, FQCN, LocationAwareLogger.INFO_INT, msg, null, null);
            return;
        }
        logger.info(msg);
    }
    

	@Override
	public void info(String format, Object... argArray) {
		if (locationAwareLogger != null) {
            locationAwareLogger.log(null, FQCN, LocationAwareLogger.INFO_INT, format, argArray, null);
            return;
        }
        logger.info(format,argArray);
		
	}

    public void info(Throwable e) {
        if (locationAwareLogger != null) {
            locationAwareLogger.log(null, FQCN, LocationAwareLogger.INFO_INT, e.getMessage(), null, e);
            return;
        }
        logger.info(e.getMessage(), e);
    }

    public void info(String msg, Throwable e) {
        if (locationAwareLogger != null) {
            locationAwareLogger.log(null, FQCN, LocationAwareLogger.INFO_INT, msg, null, e);
            return;
        }
        logger.info(msg, e);
    }

    public void warn(String msg) {
        if (locationAwareLogger != null) {
            locationAwareLogger.log(null, FQCN, LocationAwareLogger.WARN_INT, msg, null, null);
            return;
        }
        logger.warn(msg);
    }

    public void warn(Throwable e) {
        if (locationAwareLogger != null) {
            locationAwareLogger.log(null, FQCN, LocationAwareLogger.WARN_INT, e.getMessage(), null, e);
            return;
        }
        logger.warn(e.getMessage(), e);
    }

    public void warn(String msg, Throwable e) {
        if (locationAwareLogger != null) {
            locationAwareLogger.log(null, FQCN, LocationAwareLogger.WARN_INT, msg, null, e);
            return;
        }
        logger.warn(msg, e);
    }
    
	@Override
	public void warn(String format, Object... argArray) {
		 if (locationAwareLogger != null) {
	            locationAwareLogger.log(null, FQCN, LocationAwareLogger.WARN_INT, format, argArray, null);
	            return;
	        }
	        logger.warn(format,argArray);
		
	}

    public void error(String msg) {
        if (locationAwareLogger != null) {
            locationAwareLogger.log(null, FQCN, LocationAwareLogger.ERROR_INT, msg, null, null);
            return;
        }
        logger.error(msg);
    }

    public void error(Throwable e) {
        if (locationAwareLogger != null) {
            locationAwareLogger.log(null, FQCN, LocationAwareLogger.ERROR_INT, e.getMessage(), null, e);
            return;
        }
        logger.error(e.getMessage(), e);
    }

    public void error(String msg, Throwable e) {
        if (locationAwareLogger != null) {
            locationAwareLogger.log(null, FQCN, LocationAwareLogger.ERROR_INT, msg, null, e);
            return;
        }
        logger.error(msg, e);
    }
    
    @Override
	public void error(String format, Object... argArray) {
    	 if (locationAwareLogger != null) {
             locationAwareLogger.log(null, FQCN, LocationAwareLogger.ERROR_INT, format, argArray, null);
             return;
         }
         logger.error(format,argArray);
		
	}

    public boolean isTraceEnabled() {
        return logger.isTraceEnabled();
    }

    public boolean isDebugEnabled() {
        return logger.isDebugEnabled();
    }

    public boolean isInfoEnabled() {
        return logger.isInfoEnabled();
    }

    public boolean isWarnEnabled() {
        return logger.isWarnEnabled();
    }

    public boolean isErrorEnabled() {
        return logger.isErrorEnabled();
    }

	



	


}
