package com.gustinmi.test.engine;

import java.util.EnumSet;
import org.openqa.selenium.WebElement;
import com.gustinmi.config.HtmlElementOptions;

/** This is wrapper for executing atomic test action (or compound). Webdriver is assigned to instance of this class, 
 * and then you can access webpage DOM, you can click button, query elements, create HTML)
 * @author gustin
  */
public interface WebdriverTestAction {

    /**
     * @param inputData General object to allow any kind of input data (use casting in concrete example)
     * @param selector selector for html element
     * @return WebElement, for additional operations
     * @throws InterruptedException
     */
    WebElement execute(Object inputData, String selector, EnumSet<HtmlElementOptions> opts) throws InterruptedException;

    /** Should our test thread wait for webdriver and webbrowser to complete their actions (waiting for SSL certificate selection, or just slow code)
     * @return
     */
    boolean useDelay();

    /** If use delay is set to TRUE, test tread will be paused for this duration
     * @return
     */
    int delayInMillis();
}
