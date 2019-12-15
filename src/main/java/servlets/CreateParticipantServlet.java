package servlets;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="create_participant_servlet", urlPatterns = {"/createnewplayer.html"})

public class CreateParticipantServlet extends HttpServlet {

    private static Logger logger = LogManager.getLogger(CreateParticipantServlet.class);

    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {

        logger.info("Creating a new user");

        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        out.println("<html lang=\"en\"><head><meta charset=\"UTF-8\"><meta charset=\"UTF-8\"><title>Create New Player</title>");
        out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"form.css\"></head>");
        out.println("<body> Create New Player <form action=\"/newplayercreated.html\" method=\"POST\" id=\"contact\" name=\"contact\" accept-charset=\"utf-8\">");
        out.println("<label><span>Name</span><input name=\"name\" type=\"text\" placeholder=\"Name\"/></label>");
        out.println("<label><span>Email</span><input name=\"email\" type=\"email\" placeholder=\"Email\"/></label>");
        out.println("<input name=\"submit\" type=\"submit\" /></form></body></html>");
        out.close();

    }


}
