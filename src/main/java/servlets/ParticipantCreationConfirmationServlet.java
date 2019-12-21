package servlets;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import dao.ParticipantDao;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet (name="create_participant_servlet", urlPatterns = {"/newplayerconfirmation.html"})

public class ParticipantCreationConfirmationServlet extends HttpServlet {

    final String DB_NAME = "ThePetProjectDB";
    final String COLLECTION_NAME = "Participants";
    MongoClient mongoClient = new MongoClient();
    MongoDatabase mdb = mongoClient.getDatabase(DB_NAME);
    MongoCollection participants = mdb.getCollection(COLLECTION_NAME);

    private ParticipantDao pdao = new ParticipantDao(participants);


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        HttpSession session = request.getSession();
        String firstName = (String) session.getAttribute("name");
        String email = (String) session.getAttribute("email");

        // TODO: redirect to the create_player page if there are no cookies

        PrintWriter out = response.getWriter();
        out.println("<html><body> user has been created: ");
        out.println("user name: " + firstName);
        out.println("user email: " + email);
        out.println("</body></html>");
        out.close();
    }

}
