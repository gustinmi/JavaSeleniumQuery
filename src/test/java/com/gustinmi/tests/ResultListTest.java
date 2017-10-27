package com.gustinmi.tests;

import java.util.List;
import java.util.logging.Logger;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.gustinmi.config.LoggingFactory;
import com.gustinmi.test.engine.JTestDriver;


public class ResultListTest extends JTestDriver {

    public static final Logger log = LoggingFactory.loggerForThisClass();

    @Test
    public void test() {

        log.info("Result view test");

        WebElement resultList = $("#resultView");
        List<WebElement> links = resultList.findElements(By.xpath("//*[@id=\"resultView\"]/li/article/div/h2/a"));

        for (final WebElement link : links) {

            log.info(" Link " + link.getText());

        }


    }

}
