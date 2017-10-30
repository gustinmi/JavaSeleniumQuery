package com.gustinmi.tests;

import java.util.EnumSet;
import java.util.logging.Logger;
import org.junit.Test;
import com.gustinmi.config.HtmlElementOptions;
import com.gustinmi.config.LoggingFactory;
import com.gustinmi.test.Actions;
import com.gustinmi.test.engine.JTestDriver;

public class SearchingTest extends JTestDriver {

    public static final Logger log = LoggingFactory.loggerForThisClass();

    @Test
    //@Ignore
    public void test() throws InterruptedException {

        log.info("Search testing");

        log.info("Executing search test - search by click button");
        new Actions.FillinputField(this.driver).execute("avoid using", ".js-search-input", EnumSet.noneOf(HtmlElementOptions.class));
        new Actions.ClickButton(this.driver).execute(null, ".buttonSearch", EnumSet.noneOf(HtmlElementOptions.class));

        log.info("Executing search test - search by typing data");
        new Actions.FillinputField(this.driver).execute("avoi", ".js-search-input", EnumSet.of(HtmlElementOptions.BLUR));

        log.info("All search test finished");
    }

}
