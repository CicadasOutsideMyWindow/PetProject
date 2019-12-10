package server;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.webapp.WebAppContext;
import servlets.AllParticipantsServlet;
import servlets.CreateParticipantServlet;


public class WebServer {

    public static void main(String[] args) throws Exception {

        WebAppContext webApp = new WebAppContext();
        webApp.setResourceBase("/src/main/webapp");
        webApp.setWelcomeFiles(new String[] {"createnewplayer.html"});
        webApp.setContextPath("/");
        webApp.addServlet(AllParticipantsServlet.class, "/participants");
        webApp.addServlet(CreateParticipantServlet.class, "/newplayerconfirmation.html");

        DefaultServlet defaultServlet = new DefaultServlet();
        ServletHolder holderPwd = new ServletHolder("default", defaultServlet);
        holderPwd.setInitParameter("resourceBase", "./src/main/webapp/");
        webApp.addServlet(holderPwd, "/*");

        Server server = new Server(8080);
        server.setHandler(webApp);

        server.start();
        server.join();
    }
}
