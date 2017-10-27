package com.gustinmi.test.engine;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.gustinmi.config.LoggingFactory;

/** This is the main method for retrieving webpage's elements.
 * Three selectors are supported. If these are not enought, you can use javascripotContext and execute javascript directly.
 * The elements are searched for in time span of 5 seconds. 
 * If element is not found, the null is returned.
 * @author gustin
 *
 */
public class FindElementFactory {
    
    public static final Logger log = LoggingFactory.loggerForThisClass();
    
    public static WebElement findWebElement(WebDriver driver, final By by) {
        if (by == null) throw new IllegalArgumentException("Empty selector given!");
        try {
            return (new WebDriverWait(driver, 5)).until(ExpectedConditions.visibilityOfElementLocated(by));
        }catch(org.openqa.selenium.NoSuchElementException | TimeoutException nsee) {
            log.log(Level.SEVERE, nsee.getMessage(), nsee);
        }
        return null;
    }
    
    /** Finds elements or wait fiex amount of time, until element is found.
     * Usage :
     * 
     *  <code>
     *  
     *  "#idSelector"
     *  ".classSelector"
     *  "xPATHSelector" 
     *  
     *  </code>
     * @param driver
     * @param sel
     * @return
     */
    public static WebElement findWebElement(WebDriver driver, String sel) {
        final By by;
        if (sel.startsWith("#"))
            by = By.id(sel.substring(1));
        else if (sel.startsWith(".") || sel.startsWith("["))
            by = By.cssSelector(sel);
        else if (sel.startsWith("//"))
            by = By.xpath(sel);
        else {
            throw new IllegalArgumentException("Selector [" + sel + "] is not suported!");
        } 

        long startTime = System.currentTimeMillis();
        try {
            WebElement foundElt = new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(by));

            log.info(String.format("Element found in %s milis", System.currentTimeMillis() - startTime));

            return foundElt;

        }catch(org.openqa.selenium.NoSuchElementException | TimeoutException nsee) {
            log.log(Level.SEVERE, String.format("Exception occured : %s while element not found in %s ", System.currentTimeMillis() - startTime, nsee.getMessage()), nsee);
        }
        finally {

        }
        
        return null;
    }
    
    
}
