package servlets;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import dao.ParticipantDao;
import model.Participant;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "participantCreated", urlPatterns = {"/newplayercreated.html"})
public class ParticipantCreatedServlet extends HttpServlet {

    private static Logger logger = LogManager.getLogger(ParticipantCreatedServlet.class);

    final String DB_NAME = "ThePetProjectDB";
    final String COLLECTION_NAME = "Participants";
    MongoClient mongoClient = new MongoClient();
    MongoDatabase mdb = mongoClient.getDatabase(DB_NAME);
    MongoCollection participants = mdb.getCollection(COLLECTION_NAME);

    ParticipantDao pdao = new ParticipantDao(participants);

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String firstName = request.getParameter("name");
        String email = request.getParameter("email");

        Participant p = new Participant(firstName, email);
        pdao.create(p);

        logger.info(String.format("New user created: %s, %s", firstName, email));
        System.out.println(String.format("New user created: %s, %s", firstName, email));

        response.sendRedirect(String.format("/newplayerconfirmation.html?name=%s&email=%s", firstName, email));
        logger.info(String.format("Response redirected"));
    }



}
