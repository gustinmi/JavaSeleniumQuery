package com.gustinmi.jetty;

import static com.gustinmi.config.Config.*;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.AbstractHandler;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.junit.Ignore;
import org.junit.Test;
import com.gustinmi.config.LoggingFactory;

/** Starts embedded web server, with webserver root dir pointing to src/test/resources/webapp
 * Local webserver is here for demonstration purposes. Root dir can be any location. 
 * The purpose of webserver is also the ability to execute ajax requests on the demo.
 * @author gustin
 *
 */
public class JettyRunner {

    public static final Logger log = LoggingFactory.loggerForThisClass();

    public static final TesthostHandler instance = new TesthostHandler();

    private final static AtomicBoolean alreadyStarted = new AtomicBoolean(false);

    /** Instance of the jetty webserver. This instance is singleton, and will be run in background, after executing testsuite 
     * @see com.gustinmi.junit.MySuite
     * @author gustin
     *
     */
    public static class TesthostHandler extends AbstractHandler {

        protected Server server;

        @Override
        public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

            log.info("Handler execuited");

            // Declare response encoding and types
            response.setContentType("text/html; charset=utf-8");

            // Declare response status code
            response.setStatus(HttpServletResponse.SC_OK);

            // Write back response
            response.getWriter().println("<h1>This is test server</h1>");

            // Inform jetty that this request has now been handled
            baseRequest.setHandled(true);
        }

        public void startJetty() throws Exception {
            this.server = new Server(JETTY_PORT);

            final ResourceHandler resource_handler = new ResourceHandler();
            resource_handler.setDirectoriesListed(true);
            resource_handler.setWelcomeFiles(new String[] { "index.html" });
            resource_handler.setResourceBase(WEB_ROOT);
            if (DUMP_JETTY_STDERR) resource_handler.dumpStdErr();
         
            final TesthostHandler rest = new TesthostHandler();
            if (DUMP_JETTY_STDERR) rest.dumpStdErr();

            final HandlerList handlers = new HandlerList();
            handlers.setHandlers(new Handler[] { resource_handler, rest });

            server.setHandler(handlers);
            server.start();
            if (DUMP_JETTY_STDERR) server.dumpStdErr();
            log.info("Jetty started");
        }

        public void stopJetty() throws Exception {
            server.stop();
        }
    }

    public static void start() {

        if (alreadyStarted.get()) return;

        try {
            log.info("Starting jetty ...");
            instance.startJetty();
            log.info("Started");
            //Thread.sleep(100000);
            //instance.stopJetty();
        } catch (Exception e) {
            log.log(Level.SEVERE, "Error while starting / running jetty.", e);
            throw new IllegalStateException("Cannot continue", e);
        }
        finally {
            alreadyStarted.set(true);
            log.info("jetty stopped");
        }
    }

    @Ignore
    @Test
    public void test() throws Exception {

        JettyRunner.start();

    }

}
