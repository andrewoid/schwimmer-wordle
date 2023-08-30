package schwimmer.wordle.servlet;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletHandler;

/**
 * Runs the WordleDictionary servlet locally.
 * It can be accessed through the browser with at http://localhost:8080/definition?word=party
 */
public class JettyMain {

    public static void main(String[] args) throws Exception {
        Server server = new Server();
        ServerConnector connector = new ServerConnector(server);
        connector.setPort(8080);
        server.setConnectors(new Connector[]{connector});

        ServletHandler handler = new ServletHandler();
        handler.addServletWithMapping(WordleDictionaryServlet.class, "/definition");
        server.setHandler(handler);

        server.start();
    }

}
