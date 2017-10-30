package com.gustinmi.test;

import java.util.EnumSet;
import java.util.logging.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.gustinmi.config.HtmlElementOptions;
import com.gustinmi.config.LoggingFactory;
import com.gustinmi.test.engine.WebAction;
import com.gustinmi.test.engine.WebdriverTestAction;

/** Actions are reocurring patterns for executing some common tasks on HTML page.
 * They aim at reducing number of boilerplate code (and copy paste) for executing some of the most
 * common task. For specific actions you can use web driver right from unit test
 * @see com.gustinmi.test.engine.JTestDriver#$
 * @author gustin
 *
 */
public class Actions {

    /** Fills a HTML <input> field and triggers blur event if requested
     * @author gustin
     *
     */
    public static class FillinputField extends WebAction implements WebdriverTestAction {
    
        public static final Logger log = LoggingFactory.loggerForThisClass();
    
        public FillinputField(WebDriver driver) {
            super(driver);
        }
    
        @Override
        public WebElement execute(Object inputData, String selector, EnumSet<HtmlElementOptions> opts) throws InterruptedException {

            final String inputFieldValue = (String) inputData;
            if (inputFieldValue == null || inputFieldValue.isEmpty()) {
                log.warning("Empty value for input filed. Nothing will be done.");
                return null;
            }

            final WebElement inputField = $(selector);

            // enter the value
            inputField.clear(); // empty the text box
            inputField.sendKeys(inputFieldValue);
            if (useDelay()) Thread.sleep(delayInMillis());

            if (opts.contains(HtmlElementOptions.BLUR)) {

                // send tab key to leave the input. This will fire focusChange (fire any event handlers assigned to valueChange, onLeave, etc..)
                inputField.sendKeys("\t");
                if (useDelay()) Thread.sleep(delayInMillis());

            }
    
            return inputField;
        }

        @Override
        public boolean useDelay() {
            return true;
        }

        @Override
        public int delayInMillis() {
            return 500;
        }
    
    
    }

    /** Clicks a button or any other clickable element on the page
     * @author gustin
     *
     */
    public static class ClickButton extends WebAction implements WebdriverTestAction {

        public static final Logger log = LoggingFactory.loggerForThisClass();

        public ClickButton(WebDriver driver) {
            super(driver);
        }

        @Override
        public WebElement execute(Object inputData, String selector, EnumSet<HtmlElementOptions> opts) throws InterruptedException {
            final WebElement button = $(selector);
            button.click();
            if (useDelay()) Thread.sleep(delayInMillis());
            return button;
        }

        @Override
        public boolean useDelay() {
            return false;
        }

        @Override
        public int delayInMillis() {
            return 0;
        }

    }

}
