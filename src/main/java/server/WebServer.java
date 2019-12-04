package server;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;
import servlets.HelloServlet;


public class WebServer {

    public static void main(String[] args) throws Exception {

        WebAppContext webApp = new WebAppContext();
        webApp.setResourceBase("/src/main/webapp");
        webApp.setContextPath("/");
        webApp.addServlet(HelloServlet.class, "/api/*");

        Server server = new Server(8080);
        server.setHandler(webApp);

        server.start();
        server.join();
    }
}
