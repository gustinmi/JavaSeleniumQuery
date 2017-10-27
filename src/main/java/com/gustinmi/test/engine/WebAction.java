package com.gustinmi.test.engine;

import java.util.logging.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.gustinmi.config.LoggingFactory;

/** Base class to be used by test code.
 * provides access to element factory, javascript executor and webdriver
 * 
 * @author gustin
 *
 */
public class WebAction {
    
    public static final Logger log = LoggingFactory.loggerForThisClass();
    
    final private WebDriver driver;

    final private JavascriptExecutor jse;
    
    public WebAction(WebDriver driver) {
        super();
        this.driver = driver;
        jse = (JavascriptExecutor) driver;
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    public JavascriptExecutor getJse() {
        return this.jse;
    }

    public WebElement $(String sel) {
        log.info("Searching element with selector: " + sel);
        WebElement elt = FindElementFactory.findWebElement(driver, sel);
        log.info("Element found");
        return elt;
    }

}
