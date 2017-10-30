package com.gustinmi.test.engine;

import static com.gustinmi.config.Config.*;
import java.io.File;
import java.io.FileOutputStream;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.MethodRule;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import com.gustinmi.config.Config;
import com.gustinmi.config.LoggingFactory;

public class JTestDriver {
    
    public static final Logger log = LoggingFactory.loggerForThisClass();
    protected WebDriver driver;
    
    /** Try to create screenshot if error occured wqhile testing
     * @author gustin
     *
     */
    class ScreenshotTestRule implements MethodRule {
        @Override
        public Statement apply(final Statement statement, final FrameworkMethod frameworkMethod, final Object o) {
            return new Statement() {
                @Override
                public void evaluate() throws Throwable {
                    try {
                        statement.evaluate();
                    } catch (Throwable t) {
                        captureScreenshot(frameworkMethod.getName());
                        throw t; // rethrow to allow the failure to be reported to JUnit
                    }
                }

                public void captureScreenshot(String fileName) {
                    try {
                        new File("target/surefire-reports/").mkdirs(); // Insure directory is there
                        FileOutputStream out = new FileOutputStream("target/surefire-reports/screenshot-" + fileName + ".png");
                        out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
                        out.close();
                    } catch (Exception e) {
                        // No need to crash the tests if the screenshot fails
                    }
                }
            };
        }
    }
    
    @Rule
    public ScreenshotTestRule screenshotTestRule = new ScreenshotTestRule();
    
    @Before
    public void setUp() throws Exception {
        
        String driverName = System.getenv("webdriver.name");
        if (driverName == null || driverName.isEmpty()) driverName = "chrome";

        if(driverName.equalsIgnoreCase("firefox")){
        	System.setProperty("webdriver.gecko.driver", FIREFOX_WEBDRIVER_LOC);
        	
        	DesiredCapabilities cap = DesiredCapabilities.firefox();
        	cap.setCapability("marionette", true);
        	
            driver = new FirefoxDriver(cap);
        }
        else if(driverName.equalsIgnoreCase("chrome")){
            
            System.setProperty("webdriver.chrome.driver", CHROME_WEBDRIVER_LOC);
            if (USE_CHROME_WD_LOGGING) System.setProperty("webdriver.chrome.logfile", "c:\\temp\\chromedriver.log");
            
            ChromeOptions opt = new ChromeOptions();
            opt.addArguments("--disable-extensions");
            opt.addArguments("--start-maximized");
            opt.addArguments("--disable-application-cache");

            driver = new ChromeDriver(opt);
        }
        else if(driverName.equalsIgnoreCase("ie")){
            System.setProperty("webdriver.ie.driver", IE_DRIVER_LOC);
            
            DesiredCapabilities cap = new DesiredCapabilities();
            cap.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
            
            try {
                driver = new InternetExplorerDriver(cap);
            }catch(Throwable t) {
                log.log(Level.SEVERE, t.getMessage(), t);
            }
        }else {
            throw new IllegalArgumentException("Drivertype: " + driverName + "is not supported");
        }
        
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS); // wait for all elements
        
        driver.get(Config.BASE_URL + HOMEPAGE);
        
        if (Config.BASE_URL.indexOf("localhost") >= 0)
        	Thread.sleep(5000); // Give it time to wait for everything to be loaded (the first tiome is always a bit slow)

    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(5000);
        driver.quit();
    }
    
    /** Factory proxy for accessing HTMl DOM directly on unit test
     * @param sel
     * @return
     */
    public WebElement $(String sel) {
        log.info("Iščem element s selektorjem: " + sel);
        WebElement elt = FindElementFactory.findWebElement(driver, sel);
        log.info("Najden element");
        return elt;
         
    }

    
}
