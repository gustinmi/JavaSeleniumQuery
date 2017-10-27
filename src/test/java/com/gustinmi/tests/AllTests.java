package com.gustinmi.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;
import com.gustinmi.junit.MySuite;

/** Our test runner, starts jetty instance in background
 * @author gustin
 *
 */
@RunWith(MySuite.class)
@SuiteClasses({ SearchingTest.class, ResultListTest.class })
public class AllTests {
}