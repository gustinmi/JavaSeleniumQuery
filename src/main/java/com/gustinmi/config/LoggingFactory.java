package com.gustinmi.config;

import java.util.logging.Logger;

/** This methods sets correct class on logger instance.
 * In this way, we cannot write to logger and misprovide the logging event source  
 * Usage:
 * <code>
 * public static final Logger log = LoggingFactory.loggerForThisClass();
 * </code>
 * 
 * @author mitjag
 *
 */
public class LoggingFactory {

    public static final String LOG_LINE_SEPARATOR = System.getProperty("line.separator");
    
    /** Gets the logger for caller class
     * @return
     */
    public static Logger loggerForThisClass() {
        
        // We use the third stack element; second is this method, first is .getStackTrace()
        
        final StackTraceElement myCaller = Thread.currentThread().getStackTrace()[2];
        
        return Logger.getLogger(myCaller.getClassName());
    }
    
    
}
