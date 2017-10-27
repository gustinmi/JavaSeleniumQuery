package com.gustinmi.junit;

import java.util.LinkedList;
import java.util.List;
import org.junit.Ignore;
import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.Suite;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.RunnerBuilder;
import com.gustinmi.jetty.JettyRunner;

/** Custom suite implementation. Starts jetty instance in background
 * @author gustin
 * @see https://stackoverflow.com/questions/7639353/how-to-define-a-junit-method-rule-in-a-test-suite  
 */
public class MySuite extends Suite {

    // copied from Suite
    private static Class<?>[] getAnnotatedClasses(Class<?> klass) throws InitializationError {
        Suite.SuiteClasses annotation = klass.getAnnotation(Suite.SuiteClasses.class);
        if (annotation == null) { throw new InitializationError(String.format("class '%s' must have a SuiteClasses annotation", klass.getName())); }
        return annotation.value();
    }

    // copied from Suite
    public MySuite(Class<?> klass, RunnerBuilder builder) throws InitializationError {
        super(null, getRunners(getAnnotatedClasses(klass)));
    }

    public static List<Runner> getRunners(Class<?>[] classes) throws InitializationError {
        List<Runner> runners = new LinkedList<Runner>();

        for (Class<?> klazz : classes) {
            runners.add(new MyRunner(klazz));
        }

        return runners;
    }

    public static class MyRunner extends BlockJUnit4ClassRunner {

        public MyRunner(Class<?> klass) throws InitializationError {
            super(klass);

            JettyRunner.start();

        }

        @Override
        protected void runChild(final FrameworkMethod method, RunNotifier notifier) {
            Description description = describeChild(method);
            if (method.getAnnotation(Ignore.class) != null) {
                notifier.fireTestIgnored(description);
            } else {
                if (description.getAnnotation(Deprecated.class) != null) {
                    System.out.println("name=" + description.getMethodName() + " annotations=" + description.getAnnotations());
                }
                runLeaf(methodBlock(method), description, notifier);
            }
        }
    }

}