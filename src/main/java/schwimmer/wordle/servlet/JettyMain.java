package schwimmer.wordle.servlet;

import com.google.gson.Gson;
import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import schwimmer.wordle.WordleDictionary;

/**
 * Runs the WordleDictionary servlet locally.
 * It can be accessed through the browser with at http://localhost:8080/definition?word=party
 */
public class JettyMain {

    public static void main(String[] args) throws Exception {
        // Starts loads the server on port 8080
        Server server = new Server();
        ServerConnector connector = new ServerConnector(server);
        connector.setPort(8080);
        server.setConnectors(new Connector[]{connector});

        // Adds the WordleDictionaryServlet to the Server
        WordleDictionary dictionary = new WordleDictionary();
        Gson gson = new Gson();
        WordleDictionaryServlet servlet = new WordleDictionaryServlet(dictionary, gson);
        ServletHolder holder = new ServletHolder(servlet);
        ServletHandler handler = new ServletHandler();
        handler.addServletWithMapping(holder, "/definition");
        server.setHandler(handler);

        // Starts the server until this program exists.
        // You must stop the program manually
        server.start();
    }

}
