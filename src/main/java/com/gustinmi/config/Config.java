package com.gustinmi.config;

/** Main configuration values. For simplicity's sake, we use final primitive values.
 * For eneterprise use, these could be properties file or xml file, or commandline arguments. 
 * @author gustin
 *
 */
public class Config {

    /**
     *  The port the jetty will run on. port must be unoccupied 
     */
    public static final int JETTY_PORT = 8380;

    /**
     * Base URL of test webaplication. It can be any remote or local webpage
     */
    public static final String BASE_URL = String.format("http://localhost:%s/", JETTY_PORT);

    /**
     * Physical directory of test web application (for simplicity, we use fixed path)
     */
    public static final String WEB_ROOT = "c:\\Users\\gustin\\workspace\\javaselkju\\javaselkju\\src\\test\\resources\\webapp\\";

    /**
     *  Should jetty dump std error to log file 
     */
    public static final boolean DUMP_JETTY_STDERR = false;

    /**
     * Landing page URL
     */
    public static final String HOMEPAGE = "index.html";

    /**
     * The locations of firefox webdriver
     */
    public static final String FIREFOX_WEBDRIVER_LOC = "c:\\webdrivers\\geckodriver.exe";

    /**
     * The location of chrome webdriver
     */
    public static final String CHROME_WEBDRIVER_LOC = "c:\\webdrivers\\chromedriver.exe";

    /*
     * Chrome specific settings
     * */

    public static final boolean USE_CHROME_WD_LOGGING = false;

    public static final String CHROME_WEBDRIVER_LOGFILE = "c:\\temp\\chromedriver.log";

    /**
     * Location of IE Driver
     */
    public static final String IE_DRIVER_LOC = "c:\\webdrivers\\IEDriverServer.exe";

}
