package servlets;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import dao.ParticipantDao;
import model.Participant;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="create_participant_servlet", urlPatterns = {"/newplayerconfirmation.html"})

public class CreateParticipantServlet extends HttpServlet {

    final String DB_NAME = "ThePetProjectDB";
    final String COLLECTION_NAME = "Participants";
    MongoClient mongoClient = new MongoClient();
    MongoDatabase mdb = mongoClient.getDatabase(DB_NAME);
    MongoCollection participants = mdb.getCollection(COLLECTION_NAME);

    ParticipantDao pdao = new ParticipantDao(participants);

    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String firstName = request.getParameter("name");
        String email = request.getParameter("email");

        Participant p = new Participant(firstName, email);
        pdao.create(p);

        PrintWriter out = response.getWriter();
        out.println("<html><body> user has been created: ");
        out.println("user ID: " + p.getId());
        out.println("user name: " + p.getName());
        out.println("</body></html>");
    }


}
